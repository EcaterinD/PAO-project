package others;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditHelper {
    FileWriter writer;

    public AuditHelper() {
        try {
            File dir = new File("src/others");
            File file = new File("src/others/istoric.csv");
            this.writer = new FileWriter("src/others/istoric.csv",true);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addAction(String action) throws IOException {
        this.writer = new FileWriter("src/others/istoric.csv",true);
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        this.writer.write((action + ','+ timestamp + '\n'));
        this.writer.close();
    }
}