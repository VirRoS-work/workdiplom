package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Specialization implements Serializable{

    public Specialization(){
    }

    public Specialization(String field_of_activity, String specialization, boolean ready_to_move, boolean ready_for_remove_work, Applicant applicant) {
        this.field_of_activity = field_of_activity;
        this.specialization = specialization;
        this.ready_to_move = ready_to_move;
        this.ready_for_remove_work = ready_for_remove_work;
        this.applicant = applicant;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String field_of_activity;

    @Column(nullable = false)
    private String specialization;

    private boolean ready_to_move;

    private boolean ready_for_remove_work;

    @OneToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getField_of_activity() {
        return field_of_activity;
    }

    public void setField_of_activity(String field_of_activity) {
        this.field_of_activity = field_of_activity;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean isReady_to_move() {
        return ready_to_move;
    }

    public void setReady_to_move(boolean ready_to_move) {
        this.ready_to_move = ready_to_move;
    }

    public boolean isReady_for_remove_work() {
        return ready_for_remove_work;
    }

    public void setReady_for_remove_work(boolean ready_for_remove_work) {
        this.ready_for_remove_work = ready_for_remove_work;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", field_of_activity='" + field_of_activity + '\'' +
                ", specialization='" + specialization + '\'' +
                ", ready_to_move=" + ready_to_move +
                ", ready_for_remove_work=" + ready_for_remove_work +
                '}';
    }
}
