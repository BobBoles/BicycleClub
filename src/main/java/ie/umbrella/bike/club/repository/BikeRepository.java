package ie.umbrella.bike.club.repository;

import ie.umbrella.bike.club.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
