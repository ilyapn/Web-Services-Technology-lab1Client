package wst.CRUDExecutors.Soap;

import org.springframework.stereotype.Service;
import wst.CRUDExecutors.CRUDPersonExecutor;
import wst.DBClient;
import wst.generated.Person;
import wst.generated.UpdateFault;

@Service
public class SoapUpdateExecutor implements CRUDPersonExecutor {
    private final DBClient dbClient;

    public SoapUpdateExecutor(DBClient dbClient) {
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
