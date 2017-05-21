package com.thoughtworks.sharing.aws.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class GreetingController {
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
        if (!hasSignIn(session)) return "redirect:/login";
        model.addAttribute("name", getUsername(session));
        return "greeting_view";
    }

    @RequestMapping(value = "/login")
    public String showLogin(Model model, HttpSession session) {
        if (hasSignIn(session)) return "redirect:/greeting";
        return "login_view";
    }

    @PostMapping(value = "/login")
    public String doLogin(Model model,
                          @RequestParam("name") String name,
                          HttpSession session) {
        if (!hasSignIn(session)) {
            session.setAttribute("name", name);
        }
        return "redirect:/greeting";
    }
}
