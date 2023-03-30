package ie.umbrella.bike.club.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bike_id")
    private Set <Bike> bikes;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="member_race",
    joinColumns = { @JoinColumn(name="member_id")},
    inverseJoinColumns = {@JoinColumn(name="race_id")})
    private Set<Race> races = new HashSet<Race>();

    public Member() {

    }

    public Member(String email, String firstName, String lastName){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Member(String email, String firstName, String lastName, String password, Profile profile, Set<Bike> bikes, Set<Race> races) {
        this(email, firstName, lastName);
        this.password = password;
        this.profile = profile;
        this.bikes = bikes;
        this.races = races;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set getBikes() {
        return bikes;
    }

    public void setBikes(Set bikes) {
        this.bikes = bikes;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public void setRaces(Set<Race> races) {
        this.races = races;
    }




}