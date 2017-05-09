package transaction;

import org.apache.omid.transaction.RollbackException;
import org.apache.omid.transaction.Transaction;
import org.apache.omid.transaction.TransactionException;
import org.apache.omid.transaction.TransactionManager;

/**
 * Created by carlosmorais on 25/04/2017.
 */
public class TransactionManagerServiceOmid implements TransactionManagerService {

    private TransactionManager tm;

    public TransactionManagerServiceOmid(TransactionManager tm) {
        this.tm = tm;
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
