import com.listen.common.vo.GradeOption;
import com.listen.common.vo.GradeSubject;
import com.listen.pojo.Library;
import com.listen.pojo.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeSubjectTest {

    @Test
    public void test1() {

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
        l.setSubjectCount(2);
        libraries.add(l);
    }
}
