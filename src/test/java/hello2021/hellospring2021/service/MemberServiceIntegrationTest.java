package hello2021.hellospring2021.service;

import hello2021.hellospring2021.domain.Member;
import hello2021.hellospring2021.repository.MemberRepository;
import hello2021.hellospring2021.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional //테스트가 끝나면 rollback을 해줌.
class MemberServiceIntegrationTest {

    @Autowired MemberService memService;
    @Autowired MemberRepository repository;


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memService.join(member);

        //then
        Member findMember = memService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }


    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("1");
        Member member2 = new Member();
        member2.setName("1");


        //when
        memService.join(member1);

        //memService.join(member2)를 실행해서, illegal...가 터져야한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memService.join(member2);
//        fail("예외가 발생해야합니다.");
//        } catch (IllegalStateException e) {
//       Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
//        }


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}