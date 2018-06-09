package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Keyword implements Serializable {

    public Keyword() {
    }

    public Keyword(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
