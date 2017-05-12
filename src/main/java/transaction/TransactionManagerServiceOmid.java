package transaction;

import org.apache.omid.transaction.*;

import java.io.IOException;

/**
 * Created by carlosmorais on 25/04/2017.
 */
public class TransactionManagerServiceOmid implements TransactionManagerService {

    private TransactionManager tm;

    public TransactionManagerServiceOmid(TransactionManager tm) {
        this.tm = tm;
    }

    public TransactionManagerServiceOmid() throws IOException, InterruptedException {
        HBaseOmidClientConfiguration omidClientConfiguration = new HBaseOmidClientConfiguration();
        tm = HBaseTransactionManager.newInstance(omidClientConfiguration);
    }

    public TransactionService begin() throws TransactionException {
        Transaction t = tm.begin();
        return new TransactionServiceOmid(t);
    }

    public void commit(TransactionService transaction) throws RollbackException, TransactionException {
        TransactionServiceOmid t = (TransactionServiceOmid) transaction;
        tm.commit(t.getTransaction());
    }


}
