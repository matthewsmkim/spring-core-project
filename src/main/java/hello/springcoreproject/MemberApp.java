package hello.springcoreproject;

import hello.springcoreproject.member.Grade;
import hello.springcoreproject.member.Member;
import hello.springcoreproject.member.MemberService;
import hello.springcoreproject.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();    // appConfig에서 다 결정하도록 함
//        (MemberService memberService = new MemberServiceImpl();)   //


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// (메서드 이름, 타입)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }


}
