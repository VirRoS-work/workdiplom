package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SportSkill implements Serializable{

    public SportSkill() {
    }

    public SportSkill(Sport sport, Applicant applicant, String level) {
        this.sport = sport;
        this.applicant = applicant;
        this.level = level;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sport_id")
    private Sport sport;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(nullable = false)
    private String level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SportSkill{" +
                "id=" + id +
                ", sport=" + sport +
                ", applicant=" + applicant +
                ", level='" + level + '\'' +
                '}';
    }
}
