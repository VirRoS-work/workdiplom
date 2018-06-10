package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contact implements Serializable {

    public Contact() {
    }

    public Contact(ContactType contact_type, String value, Applicant applicant) {
        this.contact_type = contact_type;
        this.value = value;
        this.applicant = applicant;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contact_type_id")
    private ContactType contact_type;

    @Column(nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant  applicant;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contact_type=" + contact_type +
                ", value='" + value + '\'' +
                '}';
    }
}
