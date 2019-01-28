package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Vacancy implements Serializable{

    public Vacancy() {
    }

    public Vacancy(String status, String title, String description, Long salary_min, Long salary_max, Boolean remove_work, String type_employment, Long experience_min, Employer employer, Office office, Set<SpecializationVacancy> fields) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.salary_min = salary_min;
        this.salary_max = salary_max;
        this.remove_work = remove_work;
        this.type_employment = type_employment;
        this.experience_min = experience_min;
        this.employer = employer;
        this.office = office;
        this.fields = fields;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private Long salary_min;

    private Long salary_max;

    private Boolean remove_work;

    private String type_employment;

    private Long experience_min;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    @OneToMany(mappedBy = "vacancy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SpecializationVacancy> fields;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(Long salary_min) {
        this.salary_min = salary_min;
    }

    public Long getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(Long salary_max) {
        this.salary_max = salary_max;
    }

    public Boolean getRemove_work() {
        return remove_work;
    }

    public void setRemove_work(Boolean remove_work) {
        this.remove_work = remove_work;
    }

    public String getType_employment() {
        return type_employment;
    }

    public void setType_employment(String type_employment) {
        this.type_employment = type_employment;
    }

    public Long getExperience_min() {
        return experience_min;
    }

    public void setExperience_min(Long experience_min) {
        this.experience_min = experience_min;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Set<SpecializationVacancy> getFields() {
        return fields;
    }

    public void setFields(Set<SpecializationVacancy> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", salary_min=" + salary_min +
                ", salary_max=" + salary_max +
                ", remove_work=" + remove_work +
                ", type_employment=" + type_employment +
                ", experience_min=" + experience_min +
                '}';
    }
}
