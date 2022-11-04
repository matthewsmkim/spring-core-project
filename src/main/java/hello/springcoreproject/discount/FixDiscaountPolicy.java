package hello.springcoreproject.discount;

import hello.springcoreproject.member.Grade;
import hello.springcoreproject.member.Member;

public class FixDiscaountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {

            return 0;
        }


    }
}
