package hello.springcoreproject.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given - 이런 이런게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when - 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then - 요렇게 된다!!
        Assertions.assertThat(member).isEqualTo(findMember);                // 검증 - member가 findMember와 똑같냐?

    }
}
