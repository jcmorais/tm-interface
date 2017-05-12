package table;

import org.apache.hadoop.hbase.client.*;
import org.apache.omid.transaction.Transaction;
import transaction.TransactionService;

import java.io.IOException;

/**
 * Created by carlosmorais on 09/05/2017.
 */
public interface TxTable {

    Result get(TransactionService transaction, Get get) throws IOException;
    void put(TransactionService transaction, Put put) throws IOException;
    void flushCommits() throws IOException;
    ResultScanner getScanner(TransactionService tx, Scan scan) throws IOException;
    void delete(TransactionService tx, Delete delete) throws IOException;
}
