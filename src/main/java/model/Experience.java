package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Experience implements Serializable{

    public Experience() {
    }

    public Experience(String conpany_name, String position, Date date_start, Date date_end, String duties, String achievements, Applicant applicant) {
        this.conpany_name = conpany_name;
        this.position = position;
        this.date_start = date_start;
        this.date_end = date_end;
        this.duties = duties;
        this.achievements = achievements;
        this.applicant = applicant;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String conpany_name;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private Date date_start;

    @Column(nullable = false)
    private Date date_end;

    private String duties;

    private String achievements;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConpany_name() {
        return conpany_name;
    }

    public void setConpany_name(String conpany_name) {
        this.conpany_name = conpany_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", conpany_name='" + conpany_name + '\'' +
                ", position='" + position + '\'' +
                ", date_start=" + date_start +
                ", date_end=" + date_end +
                ", duties='" + duties + '\'' +
                ", achievements='" + achievements + '\'' +
                '}';
    }
}
