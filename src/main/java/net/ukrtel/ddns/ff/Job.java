package net.ukrtel.ddns.ff;

public class Job {
    private int id;
    private String description;

    public Job(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
