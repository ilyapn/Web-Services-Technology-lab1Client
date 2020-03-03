package wst;

import org.springframework.stereotype.Service;
import wst.CRUDExecutors.Soap.SoapDeleteExecutor;
import wst.CRUDExecutors.Soap.SoapFindExecutor;
import wst.CRUDExecutors.Soap.SoapInsertExecutor;
import wst.CRUDExecutors.Soap.SoapUpdateExecutor;

@Service
public class DBProviderSoap extends DBProvider {
    public DBProviderSoap(SoapFindExecutor soapFindExecutor,
                          SoapInsertExecutor soapInsertExecutor,
                          SoapUpdateExecutor soapUpdateExecutor,
                          SoapDeleteExecutor deleteExecutor) {
        super(soapFindExecutor, soapInsertExecutor, soapUpdateExecutor, deleteExecutor);
    }
}
