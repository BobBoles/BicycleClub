package ie.umbrella.bike.club.repository;

import ie.umbrella.bike.club.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Long> {
}
