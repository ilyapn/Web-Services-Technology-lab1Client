package wst.CRUDExecutors;

import org.springframework.stereotype.Service;
import wst.DBClient;
import wst.generated.Person;
import wst.generated.UpdateFault;

@Service
public class UpdateExecutor implements CRUDPersonExecutor {
    private final DBClient dbClient;

    public UpdateExecutor(DBClient dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public void execute(Person person) {
        try {
            System.out.println("operation status : " + dbClient.update(person));
        } catch (UpdateFault updateFault) {
            System.out.printf("update throw exception with message : %s", updateFault.getMessage());
        }
    }
}
