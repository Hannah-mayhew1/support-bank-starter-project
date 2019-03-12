package training.supportbank;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private String fromName;
    private String toName;
    private String narrative;
    private Double amount;

    public Transaction(LocalDate date, String fromName, String toName, String narrative, Double amount) {
        this.date = date;
        this.fromName = fromName;
        this.toName = toName;
        this.narrative = narrative;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFromName() {
        return fromName;
    }

    public String getToName() {
        return toName;
    }

    public String getNarrative() {
        return narrative;
    }

    public Double getAmount() {
        return amount;
    }
}
