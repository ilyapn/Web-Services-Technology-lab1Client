package wst;

import javafx.util.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import wst.generated.Field;

import java.util.List;

@Service
public class FindPrinter {
    private final DBClient dbClient;

    public FindPrinter(DBClient dbClient) {
        this.dbClient = dbClient;
    }

    public void print(Field field){
        Pair<List<String>, Integer> pair = dbClient.find(field);
        pair.getKey().forEach(System.out::println);
        System.out.println("total : "+ pair.getValue());
    }
}
