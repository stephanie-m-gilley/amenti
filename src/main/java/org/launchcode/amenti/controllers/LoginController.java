package org.launchcode.amenti.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "login")
public class LoginController {


        @RequestMapping(method = RequestMethod.GET)
        public String index() {
            return "login/index";
        }

        @RequestMapping(value = "login", method = RequestMethod.POST)
        public String login(
                @RequestParam("username") String username,
                @RequestParam("password") String password,
                HttpSession session,
                ModelMap modelMap) {
            if(username.equalsIgnoreCase("acc1") && password.equalsIgnoreCase("123")) {
                session.setAttribute("username", username);
                return "amenti/index";
            } else {
                modelMap.put("error", "Invalid Account");
                return "redirect:/login";
            }
        }

        @RequestMapping(value = "logout", method = RequestMethod.GET)
        public String logout(HttpSession session) {
            session.removeAttribute("username");
            return "redirect:...login/index";
        }

    }

