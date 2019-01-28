package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FieldOfActivity implements Serializable{

    public FieldOfActivity() {
    }

    public FieldOfActivity(String name) {
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
        return "FieldOfActivity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
