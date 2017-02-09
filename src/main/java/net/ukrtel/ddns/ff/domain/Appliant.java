package net.ukrtel.ddns.ff.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "appliants", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "email"}))
public class Appliant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;     // represents successful appliance operation

    @NotNull
    @Size(min = 1, max = 25, message = "Too short/long. should be from 1 to 25 characters.")
    private String firstname;

    @NotNull
    @Size(min = 1, max = 25, message = "Too short/long. should be from 1 to 25 characters.")
    private String surname;

    @Email
    private String email;

    private String description;

    public Appliant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appliant appliant = (Appliant) o;

        if (id != null ? !id.equals(appliant.id) : appliant.id != null) return false;
        if (firstname != null ? !firstname.equals(appliant.firstname) : appliant.firstname != null) return false;
        if (surname != null ? !surname.equals(appliant.surname) : appliant.surname != null) return false;
        if (email != null ? !email.equals(appliant.email) : appliant.email != null) return false;
        return description != null ? description.equals(appliant.description) : appliant.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appliant{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
