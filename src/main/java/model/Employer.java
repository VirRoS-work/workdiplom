package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Employer implements Serializable {

    public Employer() {
    }

    public Employer(String login, String password, String name, String type, byte number_of_person, ContactPerson contact_person, Set<Office> offices, Set<Vacancy> vacancies, Set<Contact> contacts) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.type = type;
        this.number_of_person = number_of_person;
        this.contact_person = contact_person;
        this.offices = offices;
        this.vacancies = vacancies;
        this.contacts = contacts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private byte number_of_person;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contact_person_id")
    private ContactPerson contact_person;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Office> offices;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vacancy> vacancies;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Contact> contacts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte getNumber_of_person() {
        return number_of_person;
    }

    public void setNumber_of_person(byte number_of_person) {
        this.number_of_person = number_of_person;
    }

    public ContactPerson getContact_person() {
        return contact_person;
    }

    public void setContact_person(ContactPerson contact_person) {
        this.contact_person = contact_person;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number_of_person=" + number_of_person +
                ", contact_person=" + contact_person +
                ", offices=" + offices +
                ", contacts=" + contacts +
                '}';
    }
}
