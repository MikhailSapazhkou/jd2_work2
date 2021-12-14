package by.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {


    @GetMapping(value = "/welcome.html")
    public ModelAndView welcome(@RequestParam(value = "count", required = false) Integer count) {
        ModelAndView modelAndView = new ModelAndView();

        ///// call service beans

        modelAndView.addObject("message", "Welcome to our web site! " + count);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

}
