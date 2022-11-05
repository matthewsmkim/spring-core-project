package hello.springcoreproject;

import hello.springcoreproject.discount.DiscountPolicy;
import hello.springcoreproject.discount.FixDiscaountPolicy;
import hello.springcoreproject.discount.RateDiscountPolicy;
import hello.springcoreproject.member.MemberService;
import hello.springcoreproject.member.MemberServiceImpl;
import hello.springcoreproject.member.MemoryMemberRepository;
import hello.springcoreproject.order.OrderService;
import hello.springcoreproject.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {                    // 애플리케이션 전체를 설정하고 구성한다는 뜻 (공연 기획자 역할)

    @Bean
    public MemberService memberService() {                                 // Key는 memberService
        return new MemberServiceImpl(memberRepository());                  // Value는 객체 인스턴스인 new MemberServiceImpl()로 스프링 컨테이너에 등록됨
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
       return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscaountPolicy();
        return new RateDiscountPolicy();
    }
}
