package hello2021.hellospring2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello!");
        return "hello"; //templates/hello.html tymleaf템플릿 엔진 처리
    }

    //외부 파라미터 name을 name으로 받음
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody //http의 응답 body부에 이걸 넣아주겠다.
    public String helloSpring(@RequestParam("name")String name){
        return "hello "+name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public  Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static  class Hello{
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}


