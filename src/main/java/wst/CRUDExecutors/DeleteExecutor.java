package wst.CRUDExecutors;

import org.springframework.stereotype.Service;
import wst.DBClient;
import wst.generated.DeleteFault;
import wst.generated.Person;

@Service
public class DeleteExecutor implements CRUDPersonExecutor {
    private final DBClient dbClient;

    public DeleteExecutor(DBClient dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public void execute(Person person) {
        try {
            System.out.println("operation status : " + dbClient.delete(person.getId()));
        } catch (DeleteFault deleteFault) {
            System.out.printf("delete throw exception with message : %s", deleteFault.getMessage());
        }
    }
}
