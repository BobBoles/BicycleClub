package ie.umbrella.bike.club.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String type;

    public Bike() {
    }

    Bike(String brand, String model, String type) {
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
