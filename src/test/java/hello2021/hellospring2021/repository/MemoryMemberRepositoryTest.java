package hello2021.hellospring2021.repository;

import hello2021.hellospring2021.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    //테스트 순서는 무작위이기에,  테스트 끝날때마다 클린해줘야함
    @AfterEach
    public  void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(member, result); //기대하는거,진짜 값은?
        assertThat(member).isEqualTo(result);
        assertThat(member).isEqualTo(member);
    }

    @Test
    public void findByname() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //반환 타입이 optinal일 경우,get으로 꺼냅

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("string1");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("string2");
        repository.save(member1);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
