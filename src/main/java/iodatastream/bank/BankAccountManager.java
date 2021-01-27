package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public BankAccount readAccoun(InputStream is) {
//        Path file = Path.of("/src/main/java/resources/ioreadstream/bankaccounts.txt");
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(is)) ){
            return new BankAccount(dis.readUTF(),dis.readUTF(),dis.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAccount(Path file, BankAccount ba) {
        Path.of(file.toString(), ba.getAccountNumber());
        try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            os.writeUTF(ba.getAccountNumber());
            os.writeUTF(ba.getOwner());
            os.writeInt(ba.getBalance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
