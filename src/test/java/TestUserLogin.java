import com.example.progettomola.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

public class TestUserLogin {

    SecureRandom random = new SecureRandom();
    @Test
    public void testUserLogin() {


        int id = this.random.nextInt(10000);
        User user = new User(id,"franco", "califano");
        int value = 0;

        if(user.testLogin("franco", "califano")) {
            value = 1;
        }

        Assertions.assertEquals(1, value);


    }

}
