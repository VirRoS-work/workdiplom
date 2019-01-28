package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ContactsContactPerson implements Serializable {

    public ContactsContactPerson() {
    }

    public ContactsContactPerson(ContactType contact_type, ContactPerson contact_person, String value) {
        this.contact_type = contact_type;
        this.contact_person = contact_person;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contact_type_id")
    private ContactType contact_type;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contact_person_id")
    private ContactPerson contact_person;

    @Column(nullable = false)
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ContactType getContact_type() {
        return contact_type;
    }

    public void setContact_type(ContactType contact_type) {
        this.contact_type = contact_type;
    }

    public ContactPerson getContact_person() {
        return contact_person;
    }

    public void setContact_person(ContactPerson contact_person) {
        this.contact_person = contact_person;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ContactsContactPerson{" +
                "id=" + id +
                ", contact_type=" + contact_type +
                ", contact_person=" + contact_person +
                ", value='" + value + '\'' +
                '}';
    }
}
