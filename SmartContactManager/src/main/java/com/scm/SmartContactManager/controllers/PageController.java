package com.scm.SmartContactManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) { // here this model obj is used to send dynamic data to html page.
        System.out.println("Homepage Handler...");

        // Sending data to View (home.html)
        model.addAttribute("name", "Java Spring Project");
        model.addAttribute("YoutubeChannel", "Learn Code with Durgesh");
        model.addAttribute("Google_Link", "https://www.google.com/");
        // We can show these values to html page using some Thymeleaf attributes.

        return "home"; // this will return home.html, so we need to create this in templates folder.
    }

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About Page handler");
        return "about";
    }

    @RequestMapping("/services")
    public String services() {
        return "services";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
