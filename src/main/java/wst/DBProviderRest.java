package wst;

import org.springframework.stereotype.Service;
import wst.CRUDExecutors.Rest.RestDeleteExecutor;
import wst.CRUDExecutors.Rest.RestFindExecutor;
import wst.CRUDExecutors.Rest.RestInsertExecutor;
import wst.CRUDExecutors.Rest.RestUpdateExecutor;

@Service
public class DBProviderRest extends DBProvider {
    public DBProviderRest(RestFindExecutor findExecutor,
                          RestInsertExecutor insertExecutor,
                          RestUpdateExecutor updateExecutor,
                          RestDeleteExecutor deleteExecutor) {
        super(findExecutor, insertExecutor, updateExecutor, deleteExecutor);
    }
}
