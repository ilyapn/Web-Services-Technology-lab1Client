package wst.CRUDExecutors.Soap;

import org.springframework.stereotype.Service;
import wst.CRUDExecutors.CRUDPersonExecutor;
import wst.DBClient;
import wst.generated.InsertFault;
import wst.generated.Person;

@Service
public class SoapInsertExecutor implements CRUDPersonExecutor {
    private final DBClient dbClient;

    public SoapInsertExecutor(DBClient dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public void execute(Person person) {
        try {
            System.out.println("id : " + dbClient.insert(person));
        } catch (InsertFault insertFault) {
            System.out.printf("insert throw exception with message : %s", insertFault.getMessage());
        }
    }
}
