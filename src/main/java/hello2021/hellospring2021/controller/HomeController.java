package hello2021.hellospring2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //localhost 8080으로 들어오면 여기로 이동
    public String home(){
        return "home";
    }
}
