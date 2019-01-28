package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SpecializationVacancy implements Serializable {

    public SpecializationVacancy() {
    }

    public SpecializationVacancy(FieldOfActivity field_of_activity, Vacancy vacancy, String specialization) {
        this.field_of_activity = field_of_activity;
        this.vacancy = vacancy;
        this.specialization = specialization;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "field_of_activity_id")
    private FieldOfActivity field_of_activity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

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

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "SpecializationVacancy{" +
                "id=" + id +
                ", field_of_activity=" + field_of_activity +
                ", vacancy=" + vacancy +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
