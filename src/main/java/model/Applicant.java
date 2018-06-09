package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
public class Applicant implements Serializable{

    public Applicant() {
    }

    public Applicant(String login, String password, String first_name, String last_name, String father_name, byte pol, Date date_of_birth, String email, String phone_number, PersonalData personal_data, Set<Language> languages, Specialization specialization, Experience experience, Education education, Set<Contact> contacts, Set<Summary> summaries) {
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.pol = pol;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.phone_number = phone_number;
        this.personal_data = personal_data;
        this.languages = languages;
        this.specialization = specialization;
        this.experience = experience;
        this.education = education;
        this.contacts = contacts;
        this.summaries = summaries;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    private String father_name;

    @Column(nullable = false)
    private byte pol;

    private Date date_of_birth;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone_number;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonalData personal_data;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Language> languages;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Specialization specialization;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Experience experience;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Education education;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Contact> contacts;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Summary> summaries;

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public byte getPol() {
        return pol;
    }

    public void setPol(byte pol) {
        this.pol = pol;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public PersonalData getPersonal_data() {
        return personal_data;
    }

    public void setPersonal_data(PersonalData personal_data) {
        this.personal_data = personal_data;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", pol=" + pol +
                ", date_of_birth=" + date_of_birth +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", personal_data=" + personal_data +
                ", languages=" + languages +
                ", specialization=" + specialization +
                ", experience=" + experience +
                ", education=" + education +
                ", contacts=" + contacts +
                '}';
    }
}
