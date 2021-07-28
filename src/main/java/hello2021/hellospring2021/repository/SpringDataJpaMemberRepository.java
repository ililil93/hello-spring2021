package hello2021.hellospring2021.repository;

import hello2021.hellospring2021.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> ,MemberRepository{


    @Override
    Optional<Member> findByName(String name);
}
