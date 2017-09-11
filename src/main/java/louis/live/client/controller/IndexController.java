package louis.live.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
//@PropertySource(value = {"classpath:application.properties"},encoding="utf-8")
public class IndexController {

    @Value("${live.client.title}")
    private String title;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title",title);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("title",title);
        model.addAttribute("login",true);
        return "index";
    }
}
