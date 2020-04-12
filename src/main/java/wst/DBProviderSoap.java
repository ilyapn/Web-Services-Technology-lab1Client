package wst;

import org.springframework.stereotype.Service;
import wst.CRUDExecutors.Soap.*;

@Service
public class DBProviderSoap extends DBProvider {
    public DBProviderSoap(SoapFindExecutor soapFindExecutor,
                          SoapInsertExecutor soapInsertExecutor,
                          SoapUpdateExecutor soapUpdateExecutor,
                          SoapDeleteExecutor deleteExecutor,
                          SoapImageExecutor soapImageExecutor) {
        super(soapFindExecutor, soapInsertExecutor, soapUpdateExecutor, deleteExecutor, soapImageExecutor);
    }
}
