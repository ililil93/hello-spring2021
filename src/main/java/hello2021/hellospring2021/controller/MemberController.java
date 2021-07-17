package hello2021.hellospring2021.controller;

import hello2021.hellospring2021.service.MemberService;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private  final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
