package transaction;

import hbase.HBaseTransaction;
import hbase.HBaseTransactionManager;
import hbase.RollbackException;
import hbase.Transaction;

/**
 * Created by carlosmorais on 25/04/2017.
 */
public class TransactionManagerServiceAjitts implements TransactionManagerService {
    private HBaseTransactionManager tm;

    public TransactionManagerServiceAjitts() {
        this.tm = new HBaseTransactionManager();
    }

    public HBaseTransactionManager getTm() {
        return tm;
    }

    public void setTm(HBaseTransactionManager tm) {
        this.tm = tm;
    }

    public TransactionService begin() {
        HBaseTransaction t = (HBaseTransaction) tm.begin();
        return new TransactionServiceAjitts(t);
    }

    public void commit(TransactionService transaction) throws RollbackException {
        TransactionServiceAjitts t = (TransactionServiceAjitts) transaction;
        tm.commit(t.getTransaction());
    }
}
