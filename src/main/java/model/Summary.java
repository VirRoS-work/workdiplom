package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Summary implements Serializable {

    public Summary() {
    }

    public Summary(long salary, String about_me, String city, String citizenship, byte family_status, boolean children, Applicant applicant, Set<Keyword> keywords) {
        this.salary = salary;
        this.about_me = about_me;
        City = city;
        this.citizenship = citizenship;
        this.family_status = family_status;
        this.children = children;
        this.applicant = applicant;
        this.keywords = keywords;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long salary;

    private String about_me;

    private String City;

    private String citizenship;

    private byte family_status;

    private boolean children;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "summary_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private Set<Keyword> keywords;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public byte getFamily_status() {
        return family_status;
    }

    public void setFamily_status(byte family_status) {
        this.family_status = family_status;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                ", salary=" + salary +
                ", about_me='" + about_me + '\'' +
                ", City='" + City + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", family_status=" + family_status +
                ", children=" + children +
                ", applicant=" + applicant +
                ", keywords=" + keywords +
                '}';
    }
}
