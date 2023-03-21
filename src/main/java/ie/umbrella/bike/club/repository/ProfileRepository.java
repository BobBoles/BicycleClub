package ie.umbrella.bike.club.repository;

import ie.umbrella.bike.club.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
