package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LanguageSkill implements Serializable {

    public LanguageSkill() {
    }

    public LanguageSkill(Language language, Applicant applicant, String ownership_level) {
        this.language = language;
        this.applicant = applicant;
        this.ownership_level = ownership_level;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(nullable = false)
    private String ownership_level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getOwnership_level() {
        return ownership_level;
    }

    public void setOwnership_level(String ownership_level) {
        this.ownership_level = ownership_level;
    }

    @Override
    public String toString() {
        return "LanguageSkill{" +
                "id=" + id +
                ", language=" + language +
                ", applicant=" + applicant +
                ", ownership_level='" + ownership_level + '\'' +
                '}';
    }
}
