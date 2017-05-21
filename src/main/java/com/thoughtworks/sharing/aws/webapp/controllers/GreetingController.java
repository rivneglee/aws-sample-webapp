package com.thoughtworks.sharing.aws.webapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class GreetingController {
    @Value("${app.service.node}")
    private String nodeName;

    private String getUsername(HttpSession session) {
        Object username = session.getAttribute("name");
        if (username != null
                && !username.toString().isEmpty()) {
            return username.toString();
        }

        return null;
    }

    private boolean hasSignIn(HttpSession session) {
        return getUsername(session) != null ? true : false;
    }

    @RequestMapping(value = "/greeting")
    public String showGreeting(Model model, HttpSession session) {
        System.out.println("Access greeting page at " + nodeName );
        if (!hasSignIn(session)) return "redirect:/login";
        model.addAttribute("name", getUsername(session));
        model.addAttribute("server", nodeName);
        return "greeting_view";
    }

    @RequestMapping(value = "/login")
    public String showLogin(Model model, HttpSession session) {
        System.out.println("Access login page at " + nodeName );
        model.addAttribute("server", nodeName);
        if (hasSignIn(session)) return "redirect:/greeting";
        return "login_view";
    }

    @PostMapping(value = "/login")
    public String doLogin(Model model,
                          @RequestParam("name") String name,
                          HttpSession session) {
        System.out.println("Do login at " + nodeName );
        if (!hasSignIn(session)) {
            session.setAttribute("name", name);
        }
        return "redirect:/greeting";
    }

    @RequestMapping(value = "/diagnostic")
    public String diagnostic(Model model) {
        return "diagnostic_view";
    }
}
