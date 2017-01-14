package net.ukrtel.ddns.ff;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

public class Appliant {
    private Integer id;     // represents successful appliance operation
    @NotNull private String firstname;
    @NotNull private String surname;
    @Email private String email;
    private String description;
    @NotNull private Job job;

    public Appliant() {
    }

    public Appliant(Job job) {
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
