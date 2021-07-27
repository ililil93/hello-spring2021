package hello2021.hellospring2021;

import hello2021.hellospring2021.repository.JdbcMemberRepository;
import hello2021.hellospring2021.repository.MemberRepository;
import hello2021.hellospring2021.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
        //        return new MemoryMemberRepository();

    }
}
