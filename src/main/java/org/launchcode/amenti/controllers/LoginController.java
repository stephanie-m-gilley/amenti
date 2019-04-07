package org.launchcode.amenti.controllers;
import org.launchcode.amenti.models.User;
import org.launchcode.amenti.models.data.SupplementsDao;
import org.launchcode.amenti.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    UserDao userDao;

    @Autowired
    SupplementsDao supplementsDao;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Amenti");
        return "login/index";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            ModelMap model) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if(user!= null) {
            session.setAttribute("user", user);
            // TODO: Get logged in user's supplements instead of all supplements
            model.addAttribute("supplements", supplementsDao.findAll());
            return "amenti/index";
        } else {
            final String errorMessage = "Username and/or Password do not match";
            model.addAttribute("errorMessage", errorMessage);

            //modelMap.put("error", "Invalid Account");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/login";
    }

}



