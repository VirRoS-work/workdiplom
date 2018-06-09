package model;

import controller.Connection;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Language implements Serializable {

    public Language() {
    }

    public Language(String title, String ownership_level, Applicant applicant) {
        this.title = title;
        this.ownership_level = ownership_level;
        this.applicant = applicant;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String ownership_level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnership_level() {
        return ownership_level;
    }

    public void setOwnership_level(String ownership_level) {
        this.ownership_level = ownership_level;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ownership_level='" + ownership_level + '\'' +
                '}';
    }
}
