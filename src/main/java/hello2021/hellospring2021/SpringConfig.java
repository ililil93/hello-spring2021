package hello2021.hellospring2021;

import hello2021.hellospring2021.repository.JpaMemberRepository;
import hello2021.hellospring2021.repository.MemberRepository;
import hello2021.hellospring2021.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    //    private DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new JdbcMemberRepository(dataSource);
        //        return new MemoryMemberRepository();
//    return new JdbcTmplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
