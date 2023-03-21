package ie.umbrella.bike.club.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "profile]")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String bio;
    @Temporal(TemporalType.DATE)
    private LocalDate dob;

    @OneToOne(mappedBy = "profile")
    private Member member;

}