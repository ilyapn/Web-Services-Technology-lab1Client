package wst.CRUDExecutors.Soap;

import org.springframework.stereotype.Service;
import wst.CRUDExecutors.CRUDPersonExecutor;
import wst.DBClient;
import wst.generated.DeleteFault;
import wst.generated.Person;

@Service
public class SoapDeleteExecutor implements CRUDPersonExecutor {
    private final DBClient dbClient;

    public SoapDeleteExecutor(DBClient dbClient) {
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
