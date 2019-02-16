import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.util.Random;
import java.util.UUID;

public class CreateUserTest {

    @Test
    public void test1() {
        String uuidSalt = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuidSalt);
        String password = DigestUtils.md5DigestAsHex(("1111" + uuidSalt).getBytes());
//        d9d3a3d3e4174af68fdc3cbd720aa75e
//        995195f82d953d09033c98e8b62cee1c
        System.out.println(password);
    }

    @Test
    public void test2() {
        Random r = new Random();
        System.out.println(r.nextInt(5));
    }

    @Test
    public void test3() {
        char[] answers = {'A', 'B', 'C', 'D', 'A'};
        String answerStr = "A:1;B:2;A:3;C:2;D:1";

        String[] kv = answerStr.split(";");
        if (answers.length != kv.length) {
            return;
        }
        Integer sumScore = 0;
        for (int i = 0; i < answers.length; i++) {
            String[] score = kv[i].split(":");
            if (score[0].equals(answers[i] + "")) {
                sumScore += Integer.parseInt(score[1]);
            }
        }
        System.out.println(sumScore);
    }
}
