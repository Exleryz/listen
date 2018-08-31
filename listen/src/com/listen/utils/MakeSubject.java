package com.listen.utils;

import com.listen.domain.*;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * FileName A
 * Created by Exler
 * Time 2018-08-31 9:07
 * Description: 组卷工具类
 */

public class MakeSubject {

    public static JSON initTestJson(List<Vocabulary> list1) {
        List<GradeSubject> subjectlist = new ArrayList<GradeSubject>();
        GradeSubject s = null;
        List<GradeOption> options = null;
        GradeOption o = null;
        Random r = new Random();
        for (int i = 0; i < list1.size(); i++) {
            s = new GradeSubject();
            options = new ArrayList<>();
            s.setQuestion(list1.get(i).getEnglish());
//            add option
            o = new GradeOption();
            o.setSort(0);
            o.setAnswer(true);
            o.setContent(list1.get(i).getChinese());
            options.add(o);
            o = new GradeOption();
            o.setSort(1);
            o.setAnswer(false);
            o.setContent(list1.get(i).getExplain1());
            options.add(o);
            o = new GradeOption();
            o.setSort(2);
            o.setAnswer(false);
            o.setContent(list1.get(i).getExplain2());
            options.add(o);
            o = new GradeOption();
            o.setSort(3);
            o.setAnswer(false);
            o.setContent(list1.get(i).getExplain3());
            options.add(o);
//            exchange answer
            int optionTwo = 0;
            int j = 0;
            do {
                int optionOne = r.nextInt(4);
                o = options.get(optionTwo);
                options.set(optionTwo, options.get(optionOne));
                options.set(optionOne, o);
                optionTwo = r.nextInt(options.size());
                j++;
            } while (j < 2);
            s.setCount(i);
            s.setOptions(options);
            subjectlist.add(s);
        }
        JSONArray jsonArray = JSONArray.fromObject(subjectlist);
        return jsonArray;
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

    @Test
    public void test2() {
        Random r = new Random();
        int i = r.nextInt(2);
        System.out.println(i);
    }

    @Test
    public void test3() {
        List<Subject> subjects = new ArrayList<>();
        List<Library> libraries = new ArrayList<>();
        Subject s1 = new Subject();
        s1.setOptionA("this is A");
        s1.setOptionB("this is B");
        s1.setOptionC("this is C");
        s1.setOptionD("this is D");

        s1.setSort(1);
        s1.setAnalysis("this is analysis");
        s1.setAnswer('A');
        Subject s2 = new Subject();
        s2.setOptionA("this is A");
        s2.setOptionB("this is B");
        s2.setOptionC("this is C");
        s2.setOptionD("this is D");
        s2.setSort(2);
        s2.setAnalysis("this is analysis");
        s2.setAnswer('B');
        subjects.add(s1);
        subjects.add(s2);

        Library l = new Library();
        l.setId(1);
        l.setSrc("/asdfas/sadfasdf");
        l.setSonCount(2);
        libraries.add(l);
    }
}