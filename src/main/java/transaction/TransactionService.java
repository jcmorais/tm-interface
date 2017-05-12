package transaction;

import hbase.Transaction;

/**
 * Created by carlosmorais on 25/04/2017.
 */
public interface TransactionService  {
    long startTS();
    long commitTS();
    long id();
}
