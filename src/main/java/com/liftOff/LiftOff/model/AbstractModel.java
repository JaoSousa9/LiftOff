package project.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updateDate;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", version=" + version +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
