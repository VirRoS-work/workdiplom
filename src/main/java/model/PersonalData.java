package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PersonalData implements Serializable {

    public PersonalData() {
    }

    public PersonalData(Applicant applicant, String spotr, String hobby) {
        this.applicant = applicant;
        this.spotr = spotr;
        this.hobby = hobby;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    private String spotr;

    private String hobby;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpotr() {
        return spotr;
    }

    public void setSpotr(String spotr) {
        this.spotr = spotr;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "id=" + id +
                ", spotr='" + spotr + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
