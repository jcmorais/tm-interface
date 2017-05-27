package table;

import hbase.TTable;
import hbase.Transaction;
import org.apache.hadoop.hbase.client.*;
import transaction.TransactionService;
import transaction.TransactionServiceAjitts;

import java.io.IOException;

/**
 * Created by carlosmorais on 10/05/2017.
 */
public class TTableAjitts implements TxTable {
    TTable table;

    public TTableAjitts(String table) throws IOException {
        this.table = new TTable(table);
    }

    public TTableAjitts(HTableInterface table) throws IOException {
        this.table = new TTable(table);
    }


    @Override
    public Result get(TransactionService transaction, Get get) throws IOException {
        return table.get( ((TransactionServiceAjitts) transaction).getTransaction(), get);
    }

    @Override
    public void put(TransactionService transaction, Put put) throws IOException {
        if(transaction instanceof TransactionServiceAjitts)
            table.put(((TransactionServiceAjitts) transaction).getTransaction(), put);
    }

    @Override
    public void flushCommits() throws IOException {
        table.flushCommits();
    }

    @Override
    public ResultScanner getScanner(TransactionService tx, Scan scan) throws IOException {
        return table.getScanner(((TransactionServiceAjitts) tx).getTransaction(), scan);
    }

    @Override
    public void delete(TransactionService tx, Delete delete) throws IOException {
        table.delete(((TransactionServiceAjitts) tx).getTransaction(), delete);
    }
}
