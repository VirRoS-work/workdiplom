package model;

import javax.persistence.*;

@Entity
public class ContactsApplicant {

    public ContactsApplicant() {
    }

    public ContactsApplicant(ContactType contact_type, Applicant applicant, String value) {
        this.contact_type = contact_type;
        this.applicant = applicant;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "contact_type_id")
    private ContactType contact_type;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

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

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ContactsApplicant{" +
                "id=" + id +
                ", contact_type=" + contact_type +
                ", applicant=" + applicant +
                ", value='" + value + '\'' +
                '}';
    }
}
