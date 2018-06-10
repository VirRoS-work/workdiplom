package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Education implements Serializable {

    public Education() {
    }

    public Education(String level_education, String educational_institution, String faculty, String specialization, String form_training, Date date_start, Date date_end, Applicant applicant) {
        this.level_education = level_education;
        this.educational_institution = educational_institution;
        this.faculty = faculty;
        this.specialization = specialization;
        this.form_training = form_training;
        this.date_start = date_start;
        this.date_end = date_end;
        this.applicant = applicant;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String level_education;

    @Column(nullable = false)
    private String educational_institution;

    @Column(nullable = false)
    private String faculty;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String form_training;

    @Column(nullable = false)
    private Date date_start;

    @Column(nullable = false)
    private Date date_end;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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

    public String getLevel_education() {
        return level_education;
    }

    public void setLevel_education(String level_education) {
        this.level_education = level_education;
    }

    public String getForm_training() {
        return form_training;
    }

    public void setForm_training(String form_training) {
        this.form_training = form_training;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", level_education='" + level_education + '\'' +
                ", educational_institution='" + educational_institution + '\'' +
                ", faculty='" + faculty + '\'' +
                ", specialization='" + specialization + '\'' +
                ", form_training='" + form_training + '\'' +
                ", date_start=" + date_start +
                ", date_end=" + date_end +
                '}';
    }
}
