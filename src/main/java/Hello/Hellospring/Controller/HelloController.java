package Hello.Hellospring.Controller;

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
        model.addAttribute("data", "Spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-temp";
    }
    //  쿼리스트링 받는 방식 + 값을 넘겨주는 방식

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }
    /*int 값을 받아야하는 데 쿼리 스트링으로 문자열을 넣으면 에러 발생
      서버가 멈추진 않음
    */
    //return 시 태그 값을 받을 수 있음
    @GetMapping("HelloClass")
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    /*메소드 안에서 객체를 인스턴스화 할 수 있음
      public만 json으로 넘겨줌
      메소드가 get이 붙으면 넘겨줌 -get뒤 단어를 소문자로 변경 후
    */
    class Hello {
        private String name;
        protected String prt="23";
        public String pub = "32";
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}