package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class ContactType implements Serializable {

    public ContactType() {
    }

    public ContactType(String name, Set<Contact> contacts) {
        this.name = name;
        this.contacts = contacts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "contact_type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
