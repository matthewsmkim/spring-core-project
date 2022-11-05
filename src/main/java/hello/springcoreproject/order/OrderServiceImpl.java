package hello.springcoreproject.order;

import hello.springcoreproject.discount.DiscountPolicy;
import hello.springcoreproject.member.Member;
import hello.springcoreproject.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;  // private final DiscountPolicy discountPolicy = new FixDiscaountPolicy();

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 멤버 찾자 -> 회원 정보 먼저 조회
        Member member = memberRepository.findById(memberId);
        // 할인 정책에 표현을 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);   // 할인에 대해선 discount 니가 알아서 해줘...단일 체계를 잘 지킨것
                                                                        // orderService에서 할인과 관련된 변경을 고칠 수는 없지 않는가....

        // Order 만들어서 반환 -> orderService의 역할이 끝남
        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
}
