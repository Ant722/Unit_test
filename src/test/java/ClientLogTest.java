import org.example.ClientLog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class ClientLogTest {


    @Test
    public void exportAsCSV() {
        ClientLog logObject = new ClientLog();
        logObject.log(1,5);
        File testCSV = new File("testCSV.csv");
        logObject.exportAsCSV(testCSV);
        System.out.println(testCSV.exists());
        Assertions.assertTrue(testCSV.exists());
    }
}