package ejercicio.ahmedrm.backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "BRANDS")
public class Brand implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    public Brand() { }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return "Brand {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
