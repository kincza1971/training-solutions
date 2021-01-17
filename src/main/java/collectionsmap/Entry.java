package collectionsmap;

import java.time.LocalDate;

public class Entry {
    private String IpAddress;
    private LocalDate entryDate;
    private String login;

    public Entry(String IpAddress, LocalDate entryDate, String login) {
        this.IpAddress = IpAddress;
        this.entryDate = entryDate;
        this.login = login;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public String getLogin() {
        return login;
    }
}
