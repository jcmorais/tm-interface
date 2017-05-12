package transaction;


import hbase.HBaseTransaction;

/**
 * Created by carlosmorais on 25/04/2017.
 */
public class TransactionServiceAjitts implements TransactionService {
    HBaseTransaction transaction;

    public TransactionServiceAjitts(HBaseTransaction transaction) {
        this.transaction = transaction;
    }

    public HBaseTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(HBaseTransaction transaction) {
        this.transaction = transaction;
    }

    public long startTS() {
        return transaction.getStartTimestamp();
    }

    public long commitTS() {
        return transaction.getCommitTimestamp();
    }

    public long id() {
        return transaction.getTransactionId();
    }
}
