package org.launchcode.amenti.controllers;


import org.launchcode.amenti.models.User;
import org.launchcode.amenti.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Become a Member");


        return "user/add";
    }

    //needs to add user to database. table is ready to go on mysql
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify, Errors errors) {
        model.addAttribute("user", user);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Become a Member");
            return "user/add";
        }


        if (user.getPassword().equals(verify)) {
            userDao.save(user);
            return "user/index";
        } else {
            model.addAttribute("title", "Become a Member");
            return "user/add";
        }

    }




}


