package net.ukrtel.ddns.ff.domain;

import javax.persistence.*;

@Entity
@Table(name = "applies")
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Appliant appliant;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Job job;

    private String ip;
    private Long timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appliant getAppliant() {
        return appliant;
    }

    public void setAppliant(Appliant appliant) {
        this.appliant = appliant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apply apply = (Apply) o;

        if (id != null ? !id.equals(apply.id) : apply.id != null) return false;
        if (appliant != null ? !appliant.equals(apply.appliant) : apply.appliant != null) return false;
        if (job != null ? !job.equals(apply.job) : apply.job != null) return false;
        if (ip != null ? !ip.equals(apply.ip) : apply.ip != null) return false;
        return timestamp != null ? timestamp.equals(apply.timestamp) : apply.timestamp == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (appliant != null ? appliant.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", appliant=" + appliant +
                ", job=" + job +
                ", ip=" + ip +
                ", timestamp=" + timestamp +
                '}';
    }
}
