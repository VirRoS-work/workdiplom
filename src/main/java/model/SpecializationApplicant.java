package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SpecializationApplicant implements Serializable{

    public SpecializationApplicant() {
    }

    public SpecializationApplicant(FieldOfActivity field_of_activity, Applicant applicant, String specialization) {
        this.field_of_activity = field_of_activity;
        this.applicant = applicant;
        this.specialization = specialization;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "field_of_activity_id")
    private FieldOfActivity field_of_activity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(nullable = false)
    private String specialization;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FieldOfActivity getField_of_activity() {
        return field_of_activity;
    }

    public void setField_of_activity(FieldOfActivity field_of_activity) {
        this.field_of_activity = field_of_activity;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "SpecializationApplicant{" +
                "id=" + id +
                ", field_of_activity=" + field_of_activity +
                ", applicant=" + applicant +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
