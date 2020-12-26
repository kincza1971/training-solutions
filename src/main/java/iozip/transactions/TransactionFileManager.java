package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    private byte[] getTransData(Transaction t) {
        return (t.getTime().toString() + "\n" + t.getAccount() + "\n" + t.getAmount()).getBytes(StandardCharsets.UTF_8);
    }

    public void saveTransactions(Path file, List<Transaction> transactionList) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Transaction transaction : transactionList) {
                zos.putNextEntry(new ZipEntry(Long.toString(transaction.getId())));
                zos.write(getTransData(transaction));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
