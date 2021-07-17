package hello2021.hellospring2021;

import hello2021.hellospring2021.repository.MemberRepository;
import hello2021.hellospring2021.repository.MemoryMemberRepository;
import hello2021.hellospring2021.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
    return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
