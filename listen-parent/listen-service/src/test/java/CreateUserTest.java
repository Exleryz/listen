import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CreateUserTest {

    @Test
    public void test1() {
        String uuidSalt = UUID.randomUUID().toString().replace("-","");
        System.out.println(uuidSalt);
        String password = DigestUtils.md5DigestAsHex(("123456" + uuidSalt).getBytes());
//        d9d3a3d3e4174af68fdc3cbd720aa75e
//        995195f82d953d09033c98e8b62cee1c
        System.out.println(password);
    }
}
