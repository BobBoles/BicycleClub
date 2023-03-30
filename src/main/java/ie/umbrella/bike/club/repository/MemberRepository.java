package ie.umbrella.bike.club.repository;

import ie.umbrella.bike.club.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository <Member, Long> {
    public Member findByEmail(String email);
}
