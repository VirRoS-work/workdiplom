package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
public class Applicant implements Serializable{

    public Applicant() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    private String father_name;

    @Column(nullable = false)
    private Byte pol;

    private Date date_of_birth;

    private Boolean ready_to_move;

    private Boolean ready_for_remove_work;

    private String City;

    private String Citizenship;

    private Byte family_status;

    private Boolean childrens;

    private String aboute_me;

    private String hobby;

    private Long salary;

    private String academic_dergee;

    private Byte status_summary;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<LanguageSkill> languageSkills;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SpecializationApplicant> specializationApplicants;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Experience> experiences;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Education> educations;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ContactsApplicant> contacts;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SportSkill> sportSkills;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public Byte getPol() {
        return pol;
    }

    public void setPol(Byte pol) {
        this.pol = pol;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Boolean getReady_to_move() {
        return ready_to_move;
    }

    public void setReady_to_move(Boolean ready_to_move) {
        this.ready_to_move = ready_to_move;
    }

    public Boolean getReady_for_remove_work() {
        return ready_for_remove_work;
    }

    public void setReady_for_remove_work(Boolean ready_for_remove_work) {
        this.ready_for_remove_work = ready_for_remove_work;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCitizenship() {
        return Citizenship;
    }

    public void setCitizenship(String citizenship) {
        Citizenship = citizenship;
    }

    public Byte getFamily_status() {
        return family_status;
    }

    public void setFamily_status(Byte family_status) {
        this.family_status = family_status;
    }

    public Boolean getChildrens() {
        return childrens;
    }

    public void setChildrens(Boolean childrens) {
        this.childrens = childrens;
    }

    public String getAboute_me() {
        return aboute_me;
    }

    public void setAboute_me(String aboute_me) {
        this.aboute_me = aboute_me;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getAcademic_dergee() {
        return academic_dergee;
    }

    public void setAcademic_dergee(String academic_dergee) {
        this.academic_dergee = academic_dergee;
    }

    public Byte getStatus_summary() {
        return status_summary;
    }

    public void setStatus_summary(Byte status_summary) {
        this.status_summary = status_summary;
    }

    public Set<LanguageSkill> getLanguageSkills() {
        return languageSkills;
    }

    public void setLanguageSkills(Set<LanguageSkill> languageSkills) {
        this.languageSkills = languageSkills;
    }

    public Set<SpecializationApplicant> getSpecializationApplicants() {
        return specializationApplicants;
    }

    public void setSpecializationApplicants(Set<SpecializationApplicant> specializationApplicants) {
        this.specializationApplicants = specializationApplicants;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<ContactsApplicant> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactsApplicant> contacts) {
        this.contacts = contacts;
    }

    public Set<SportSkill> getSportSkills() {
        return sportSkills;
    }

    public void setSportSkills(Set<SportSkill> sportSkills) {
        this.sportSkills = sportSkills;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", pol=" + pol +
                ", date_of_birth=" + date_of_birth +
                ", ready_to_move=" + ready_to_move +
                ", ready_for_remove_work=" + ready_for_remove_work +
                ", City='" + City + '\'' +
                ", Citizenship='" + Citizenship + '\'' +
                ", family_status=" + family_status +
                ", childrens=" + childrens +
                ", aboute_me='" + aboute_me + '\'' +
                ", hobby='" + hobby + '\'' +
                ", salary=" + salary +
                ", academic_dergee='" + academic_dergee + '\'' +
                ", status_summary=" + status_summary +
                ", languageSkills=" + languageSkills +
                ", specializationApplicants=" + specializationApplicants +
                ", experiences=" + experiences +
                ", educations=" + educations +
                ", contacts=" + contacts +
                ", sportSkills=" + sportSkills +
                '}';
    }
}
