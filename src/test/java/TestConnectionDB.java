import com.example.progettomola.DatabaseConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestConnectionDB {

    @Test
    void testConnection() {
        int value = 0;

        if(DatabaseConnection.getInstance() != null){
            value = 1;
        }

        Assertions.assertEquals(1, value);
    }

}
