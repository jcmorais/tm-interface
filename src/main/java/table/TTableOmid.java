package table;

import org.apache.hadoop.hbase.client.*;
import org.apache.omid.transaction.TTable;
import org.apache.omid.transaction.Transaction;
import transaction.TransactionService;
import transaction.TransactionServiceOmid;

import java.io.IOException;

/**
 * Created by carlosmorais on 10/05/2017.
 */
public class TTableOmid implements TxTable {

    TTable tTable;

    public TTableOmid(String table) throws IOException {
        this.tTable = new TTable(table);
    }

    public TTableOmid(HTableInterface table, HTableInterface table2) throws IOException {
        this.tTable = new TTable(table, table2);
    }

    @Override
    public Result get(TransactionService transaction, Get get) throws IOException {
        return tTable.get(((TransactionServiceOmid) transaction).getTransaction(), get);
    }

    @Override
    public void put(TransactionService transaction, Put put) throws IOException {
        if(transaction instanceof TransactionServiceOmid)
            tTable.put(((TransactionServiceOmid) transaction).getTransaction(), put);
    }

    @Override
    public void flushCommits() throws IOException {
        tTable.flushCommits();
    }

    @Override
    public ResultScanner getScanner(TransactionService tx, Scan scan) throws IOException {
        return tTable.getScanner((Transaction) tx, scan);
    }

    @Override
    public void delete(TransactionService tx, Delete delete) throws IOException {
        tTable.delete((Transaction) tx, delete);
    }
}
