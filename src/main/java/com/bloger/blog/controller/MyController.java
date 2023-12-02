package com.bloger.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/* MVC: MODEL VIEW CONTROLLER */
@Controller
public class MyController {

    @GetMapping("loghere") /* it is url text link */
    public String put_log(Model model) {
        model.addAttribute("data", "message");
        model.addAttribute("data2", "message2");
        /*return templates.somefile.html */
        return "mylog";
    }

}
