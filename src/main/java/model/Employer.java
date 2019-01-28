package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Employer implements Serializable {

    public Employer() {
    }

    public Employer(String login, String password, String name, String type, String number_of_person, String address,
                    String site, String description, Set<Office> offices, Set<Vacancy> vacancies,
                    Set<ContactPerson> contacts) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.type = type;
        this.number_of_person = number_of_person;
        this.address = address;
        this.site = site;
        this.description = description;
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
    private String number_of_person;

    @Column
    private String address;

    @Column
    private String site;

    @Column
    private String description;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Office> offices;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Vacancy> vacancies;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ContactPerson> contacts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNumber_of_person() {
        return number_of_person;
    }

    public void setNumber_of_person(String number_of_person) {
        this.number_of_person = number_of_person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<ContactPerson> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactPerson> contacts) {
        this.contacts = contacts;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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
                ", address='" + address + '\'' +
                ", site='" + site + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
