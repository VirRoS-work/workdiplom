package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Vacancy implements Serializable{

    public Vacancy() {
    }

    public Vacancy(byte status, String title, String description, long salary_min, long salary_max, boolean remove_work, byte type_employment, String field_of_activity, Employer employer, Set<Keyword> keywords) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.salary_min = salary_min;
        this.salary_max = salary_max;
        this.remove_work = remove_work;
        this.type_employment = type_employment;
        this.field_of_activity = field_of_activity;
        this.employer = employer;
        this.keywords = keywords;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private byte status;

    private String title;

    private String description;

    private long salary_min;

    private long salary_max;

    private boolean remove_work;

    private byte type_employment;

    private String field_of_activity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private Set<Keyword> keywords;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
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

    public long getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(long salary_min) {
        this.salary_min = salary_min;
    }

    public long getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(long salary_max) {
        this.salary_max = salary_max;
    }

    public boolean isRemove_work() {
        return remove_work;
    }

    public void setRemove_work(boolean remove_work) {
        this.remove_work = remove_work;
    }

    public byte getType_employment() {
        return type_employment;
    }

    public void setType_employment(byte type_employment) {
        this.type_employment = type_employment;
    }

    public String getField_of_activity() {
        return field_of_activity;
    }

    public void setField_of_activity(String field_of_activity) {
        this.field_of_activity = field_of_activity;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
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
                ", field_of_activity='" + field_of_activity + '\'' +
                ", employer=" + employer +
                ", keywords=" + keywords +
                '}';
    }
}
