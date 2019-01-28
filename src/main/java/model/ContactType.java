package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class ContactType implements Serializable {

    public ContactType() {
    }

    public ContactType(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
