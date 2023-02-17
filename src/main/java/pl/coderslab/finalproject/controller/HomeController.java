package pl.coderslab.finalproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home-page")
    public String home(){

        return "home-page";
    }
}
