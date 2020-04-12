package wst;

import javafx.util.Pair;
import org.springframework.stereotype.Service;
import wst.generated.*;

import javax.xml.ws.Holder;
import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class DBClient {
    private final DB db;

    public DBClient(DB db) {
        this.db = db;
    }

    public Pair<List<String>, Integer> find(Person person) throws FindFault_Exception {
        Holder<List<String>> find = new Holder<>();
        Holder<Integer> total = new Holder<>();
        db.find(person, find, total);
        return new Pair(find.value, total.value);
    }

    public int insert(Person person) throws InsertFault {
        return db.insert(person);
    }

    public int update(Person person) throws UpdateFault {
        return db.update(person);
    }

    public int delete(int id) throws DeleteFault {
        return db.delete(id);
    }

    public void image() throws IOException {
        byte[] img = db.image("").getImg();
        File file = new File("src/main/resources/image.jpg");
        OutputStream fileInputStream = new FileOutputStream(file);
        fileInputStream.write(img);

    }
    public Future<Object> imageAsinc(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> submit = executorService.submit(() -> {
            try {
                image();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "null";
        });
        return submit;
    }


}
