package ie.umbrella.bike.club.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String bio;
    @Temporal(TemporalType.DATE)
    private LocalDate dob;
    public Profile() {
    }

    public Profile(String address, String bio, LocalDate dob) {
        this.address = address;
        this.bio = bio;
        this.dob = dob;
    }

    public Long getId() {
        return this.id;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBio() {
        return this.bio;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}