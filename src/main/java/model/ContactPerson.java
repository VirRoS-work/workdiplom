package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class ContactPerson implements Serializable{

    public ContactPerson() {
    }

    public ContactPerson(String first_name, String last_name, String father_name, Employer employer, Set<ContactsContactPerson> contacts) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.employer = employer;
        this.contacts = contacts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    private String father_name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @OneToMany(mappedBy = "contact_person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ContactsContactPerson> contacts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Set<ContactsContactPerson> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactsContactPerson> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", employer=" + employer +
                ", contacts=" + contacts +
                '}';
    }
}
