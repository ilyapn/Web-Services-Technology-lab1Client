package wst.CRUDExecutors.Soap;

import javafx.util.Pair;
import org.springframework.stereotype.Service;
import wst.CRUDExecutors.CRUDPersonExecutor;
import wst.DBClient;
import wst.generated.FindFault_Exception;
import wst.generated.Person;

import java.util.List;

@Service
public class SoapFindExecutor implements CRUDPersonExecutor {
    private final DBClient dbClient;

    public SoapFindExecutor(DBClient dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public void execute(Person person) {
        Pair<List<String>, Integer> pair = null;
        try {
            pair = dbClient.find(person);
            pair.getKey().forEach(System.out::println);
            System.out.println("total : " + pair.getValue());
        } catch (FindFault_Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
