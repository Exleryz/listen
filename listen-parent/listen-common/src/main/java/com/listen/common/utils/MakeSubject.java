package com.listen.common.utils;

import com.listen.common.vo.GradeOption;
import com.listen.common.vo.GradeSubject;
import com.listen.pojo.Library;
import com.listen.pojo.Subject;
import com.listen.pojo.Vocabulary;
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

    public static List<GradeSubject> initTestJson(List<Vocabulary> list) {
        final List<GradeSubject> subjectList = new ArrayList<GradeSubject>();
        ScheduledExecutorService es = new ScheduledThreadPoolExecutor(10, new BasicThreadFactory.Builder().namingPattern("pool-%d").daemon(true).build());
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
                        exec(vocList, subjectList);
                    } catch (Exception e) {
                    }finally {
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

    private static void exec(List<Vocabulary> vocList, List<GradeSubject> subjectList) {
        for (int i = 0; i < vocList.size(); i++) {
            GradeSubject s = new GradeSubject();
            List<GradeOption> options = null;
            GradeOption o = null;
            options = new ArrayList<>();
            s.setQuestion(vocList.get(i).getEnglish());
            // add option
            for (int j = 0; j < 4; j++) {
                o = new GradeOption();
                o.setSort(j);
                o.setAnswer(j == 0);
                o.setContent(j == 0 ? vocList.get(i).getChinese() : j == 1 ? vocList.get(i).getExplain1() : j == 2 ? vocList.get(i).getExplain2() : vocList.get(i).getExplain3());
                options.add(o);
            }
            // exchange answer
            int optionTwo = 0;
            int j = 0;
            Random r = new Random();
            do {
                int optionOne = r.nextInt(4);
                o = options.get(optionTwo);
                options.set(optionTwo, options.get(optionOne));
                options.set(optionOne, o);
                optionTwo = r.nextInt(options.size());
                j++;
            } while (j < 2);
            synchronized (subjectList) {
                s.setCount(subjectList.size());
                s.setOptions(options);
                subjectList.add(s);
            }
        }
    }

    public static String initSubject(List<Library> libraries, List<Subject> subjects) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int sonCount;
        sb.append("[");
        for (int i = 0; i < libraries.size(); i++) {
            sb.append("{\"count\": " + i + "," +
                    "\"src\": \"" + libraries.get(i).getSrc() + "\"," +
                    "\"questions\":[");
            sonCount = libraries.get(i).getSonCount();
            for (int j = count % sonCount; j < sonCount; j++, count++) {
                sb.append("{\"analysis\":\"" + subjects.get(count).getAnalysis() + "\"," +
                        "\"options\": [");

                String[] strs = new String[4];
                // 为什么不能直接转json?
                if (subjects.get(count).getAnswer().equals('A'))
                    strs[0] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionA() + "\",\"answer\":\"" + "true" + "\"}},");
                else
                    strs[0] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionA() + "\",\"answer\":\"" + "false" + "\"}},");
                if (subjects.get(count).getAnswer().equals('B'))
                    strs[1] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionB() + "\",\"answer\":\"" + "true" + "\"}},");
                else
                    strs[1] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionB() + "\",\"answer\":\"" + "false" + "\"}},");
                if (subjects.get(count).getAnswer().equals('C'))
                    strs[2] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionC() + "\",\"answer\":\"" + "true" + "\"}},");
                else
                    strs[2] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionC() + "\",\"answer\":\"" + "false" + "\"}},");
                if (subjects.get(count).getAnswer().equals('D'))
                    strs[3] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionD() + "\",\"answer\":\"" + "true" + "\"}},");
                else
                    strs[3] = ("{\"option\":{\"content\":\"" + subjects.get(count).getOptionD() + "\",\"answer\":\"" + "false" + "\"}},");

                Random r = new Random();
                String temp = null;
                for (int k = 0; k < 3; k++) {
                    int one = r.nextInt(strs.length);
                    int two = r.nextInt(strs.length);
                    temp = strs[one];
                    strs[one] = strs[two];
                    strs[two] = temp;
                }

                sb.append(strs[0]);
                sb.append(strs[1]);
                sb.append(strs[2]);
                sb.append(strs[3]);
                sb.deleteCharAt(sb.length() - 1);
                sb.append("]},");
            }
            count = 0;
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]},");

        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}