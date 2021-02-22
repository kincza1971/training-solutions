package exam03retake;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<Mail> mailList = new ArrayList<>();

    public void addMail(Mail mail) {
        if (mail == null) {
            throw new IllegalArgumentException("Mail cannot be null");
        }
        mailList.add(mail);
    }

    private List<Mail> findByFrom(String from) {
        List<Mail> result = new ArrayList<>();
        String[] parts = from.split(":");
        for (Mail mail : mailList) {
            if (mail.getFrom().getEmail().equals(parts[1])) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findByTo(String to) {
        List<Mail> result = new ArrayList<>();
        String[] parts = to.split(":");
        for (Mail mail : mailList) {
            for (Contact contact : mail.getTo()) {
                if (contact.getName().equals(parts[1])) {
                    result.add(mail);
                }
            }
        }
        return result;
    }

    private List<Mail> findByText(String text) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mailList) {
            if (mail.getMessage().contains(text) || mail.getSubject().contains(text)) {
                result.add(mail);
            }
        }
        return result;
    }

    public List<Mail> findByCriteria(String criteria) {
        if (criteria.contains("from:")) {
            return findByFrom(criteria);
        } else if (criteria.contains("to:")) {
            return findByTo(criteria);
        } else {
            return findByText(criteria);
        }
    }


    public List<Mail> getMails() {
        return new ArrayList<>(mailList);
    }

}
