package wst;

import javafx.util.Pair;
import org.springframework.stereotype.Service;
import wst.generated.DB;
import wst.generated.Field;

import javax.xml.ws.Holder;
import java.util.List;

@Service
public class DBClient {
    private final DB db;

    public DBClient(DB db) {
        this.db = db;
    }

    public Pair<List<String>, Integer> find(Field field) {
        Holder<List<String>> find = new Holder<>();
        Holder<Integer> total = new Holder<>();
        db.find(field, find, total);
        return new Pair(find.value, total.value);
    }


}
