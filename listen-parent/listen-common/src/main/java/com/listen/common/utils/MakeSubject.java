package com.listen.common.utils;

import com.listen.common.redis.RedisHelper;
import com.listen.common.vo.GradeOption;
import com.listen.common.vo.GradeSubject;
import com.listen.common.vo.LibraryVo;
import com.listen.pojo.Subject;
import com.listen.pojo.Vocabulary;
import com.listen.pojo.vo.QueryLibraryVo;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * FileName A
 *
 * @author Exler
 * Time 2018-08-31 9:07
 * Description: 组卷工具类
 */

public class MakeSubject {

    /**
     * 单词
     *
     * @param list
     * @return
     */
    public static List<GradeSubject> initVocabulary(List<Vocabulary> list) {
        final List<GradeSubject> subjectList = new ArrayList<GradeSubject>();
        ScheduledExecutorService es = new ScheduledThreadPoolExecutor(10, new BasicThreadFactory.Builder().namingPattern("Vocabulary-pool-%d").daemon(true).build());
        // 题目总数50 10个数组一处理 需要计数5次
        final CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            final List<Vocabulary> vocList = new ArrayList<Vocabulary>();
            for (int j = 0; j < 10; j++) {
                Vocabulary vocabulary = list.remove(0);
                vocList.add(vocabulary);
            }
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        execVocabulary(vocList, subjectList);
                    } catch (Exception e) {
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        es.shutdown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            return null;
        }
        return subjectList;
    }

    private static void execVocabulary(List<Vocabulary> vocList, List<GradeSubject> subjectList) {
        for (int i = 0; i < vocList.size(); i++) {
            GradeSubject s = new GradeSubject();
            List<GradeOption> options = null;
            GradeOption o = null;
            options = new ArrayList<>();
            s.setQuestion(vocList.get(i).getEnglish());
            // add option
            for (int j = 0; j < 4; j++) {
                o = new GradeOption();
                o.setAnswer(j == 0);
                o.setContent(j == 0 ? vocList.get(i).getChinese() : j == 1 ? vocList.get(i).getExplain1() : j == 2 ?
                        vocList.get(i).getExplain2() : vocList.get(i).getExplain3());
                options.add(o);
            }
            // exchange answer
            // add
            s.setOptions(changeVocabulary(options, 0));
            s.setGrade(vocList.get(i).getGrade());
            synchronized (subjectList) {
                subjectList.add(s);
            }
        }
    }

    private static List<GradeOption> changeVocabulary(List<GradeOption> options, int index) {
        // 交换选项
        Random r = new Random();
        int randomOption = r.nextInt(4);
        GradeOption tempOption = options.get(index);
        options.set(index, options.get(randomOption));
        options.set(randomOption, tempOption);
        return options;
    }

    /**
     * 题目
     *
     * @param vos
     * @return
     */
    public static List<LibraryVo> initSubject(List<QueryLibraryVo> vos, Integer userId, Integer currentPoint) {
        final List<LibraryVo> libraryVosList = new ArrayList<>(vos.size());
        StringBuilder sb = new StringBuilder();
        for (final QueryLibraryVo vo : vos) {
            sb.append(execSubject(vo, libraryVosList));
        }
        sb.deleteCharAt(sb.length() - 1);
        RedisHelper.set(userId + "ANSWER_KEY:" + currentPoint, sb.toString(), 1200, 1);
        return libraryVosList;
    }

    private static String execSubject(QueryLibraryVo queryVo, List<LibraryVo> voList) {
        // 大题Vo
        LibraryVo vo = new LibraryVo();
        // 题目list
        List<GradeSubject> newSubjects = new ArrayList<>();
        vo.setSrc(queryVo.getSrc());
        vo.setSonCount(queryVo.getSonCount());
        StringBuilder sb = new StringBuilder();
        for (Subject subject : queryVo.getSubjects()) {
            // 获取正确答案
            int tempSort = subject.getAnswer() - 'A';
            List<GradeOption> options = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                GradeOption option = new GradeOption();
                option.setContent(i == 0 ? subject.getOptionA() : i == 1 ? subject.getOptionB() : i == 2 ?
                        subject.getOptionC() : subject.getOptionD());
                options.add(option);
            }
            // 交换选项
            change(options, tempSort);
            GradeSubject newSubject = new GradeSubject();
            newSubject.setOptions(options);
            newSubjects.add(newSubject);
            // 例如: A:1;
            sb.append(change(options, tempSort));
            sb.append(":");
            sb.append(queryVo.getDifficulty());
            sb.append(";");
        }
        vo.setSubjects(newSubjects);
        voList.add(vo);
        return sb.toString();
    }

    private static Character change(List<GradeOption> options, int index) {
        // 交换选项
        Random r = new Random();
        int randomOption = r.nextInt(4);
        GradeOption tempOption = options.get(index);
        options.set(index, options.get(randomOption));
        options.set(randomOption, tempOption);
        return (char) ('A' + randomOption);
    }
}