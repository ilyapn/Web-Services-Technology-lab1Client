package wst.CRUDExecutors.Soap;

import org.springframework.stereotype.Service;
import wst.DBClient;

import java.io.IOException;
import java.util.concurrent.Future;

@Service
public class SoapImageExecutor {

    private final DBClient dbClient;

    public SoapImageExecutor(DBClient dbClient) {
        this.dbClient = dbClient;
    }

    public void execute() throws IOException {
        dbClient.image();
    }

    public Future<Object> executeAsinc() {
        return dbClient.imageAsinc();
    }

}
