package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Education implements Serializable {

    public Education() {
    }

    public Education(String educational_institution, String faculty, String specialization, Date date_start, Date date_end, Applicant applicant) {
        this.educational_institution = educational_institution;
        this.faculty = faculty;
        this.specialization = specialization;
        this.date_start = date_start;
        this.date_end = date_end;
        this.applicant = applicant;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String educational_institution;

    private String faculty;

    private String specialization;

    private Date date_start;

    private Date date_end;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEducational_institution() {
        return educational_institution;
    }

    public void setEducational_institution(String educational_institution) {
        this.educational_institution = educational_institution;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", educational_institution='" + educational_institution + '\'' +
                ", faculty='" + faculty + '\'' +
                ", specialization='" + specialization + '\'' +
                ", date_start=" + date_start +
                ", date_end=" + date_end +
                '}';
    }
}
