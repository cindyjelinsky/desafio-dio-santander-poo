package domain;

import java.time.LocalDate;

import static domain.Content.XP_DEFAULT;

public class Mentoring extends Content {

    private LocalDate date;

    @Override
    public double calcXp() {
        return XP_DEFAULT + 20d;
    }

    public Mentoring() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  "Mentoring{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", date=" + date +
                '}';
    }
}
