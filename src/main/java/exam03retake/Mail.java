package exam03retake;

import java.util.List;

public class Mail {
    private final Contact from;
    private final List<Contact> to;
    private final String subject;
    private final String Message;

    public Mail(Contact from, List<Contact> to, String subject, String message) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        Message = message;
    }

    public Contact getFrom() {
        return from;
    }

    public List<Contact> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return Message;
    }
    

}
