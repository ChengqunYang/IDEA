package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *请求参数的绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定
     * @return
     */
    @RequestMapping("/testParam")
    public String testPram(String username) {
        System.out.println("....running:"+username);
        return "success";
    }
}
