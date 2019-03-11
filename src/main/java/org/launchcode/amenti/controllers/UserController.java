package org.launchcode.amenti.controllers;


import org.launchcode.amenti.models.User;
import org.launchcode.amenti.models.data.SupplementsDao;
import org.launchcode.amenti.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value="user")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    SupplementsDao supplementsDao;


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Become a Member");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        model.addAttribute("user", user);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Become a Member");
            return "user/add";
        }

        if (user.getPassword().equals(verify)) {
            userDao.save(user);
            model.addAttribute("supplements", supplementsDao.findAll());
            model.addAttribute("user", user);
            return "user/index";
        } else {
            model.addAttribute("title", "Become a Member");
            return "user/add";
        }
    }

}


