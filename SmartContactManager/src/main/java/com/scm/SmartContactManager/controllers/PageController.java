package com.scm.SmartContactManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.SmartContactManager.forms.UserForm;

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
    public String register(Model model) {

        UserForm userForm = new UserForm();
        userForm.setName("Mohit");
        model.addAttribute("userForm", userForm);

        return "register";
    }

    // Processing Register Form
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister() {
        // fetch the data
        // send to model (make a userForm class & receive data there in an object )
        // validate form data
        // save to database
        // message (Registration Successful)
        // redirect to any page
        return "redirect:/register";
    }
}
