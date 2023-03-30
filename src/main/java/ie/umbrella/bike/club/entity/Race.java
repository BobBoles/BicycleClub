package ie.umbrella.bike.club.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int distance;
    @Column(unique = true)
    private String raceName;
    @Temporal(TemporalType.DATE)
    private LocalDate startTime;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Member> competitors;

    public Race() {
    }

    public Race(String raceName, int distance, LocalDate startTime) {
        this.raceName = raceName;
        this.distance = distance;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public Set<Member> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Set<Member> competitors) {
        this.competitors = competitors;
    }
}
