package war.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public class AboutController {

    @RequestMapping("/about")
    public String welcome (Map<String, Object> model){
        return "about";
    }
}
