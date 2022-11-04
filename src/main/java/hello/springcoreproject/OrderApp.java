package hello.springcoreproject;

import hello.springcoreproject.member.Grade;
import hello.springcoreproject.member.Member;
import hello.springcoreproject.member.MemberService;
import hello.springcoreproject.member.MemberServiceImpl;
import hello.springcoreproject.order.Order;
import hello.springcoreproject.order.OrderService;
import hello.springcoreproject.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // memberService를 통해 메모리 객체에 넣어야됨 -> 그래야 주문에서 찾아 쓸 수 있으니
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
