package org.launchcode.amenti.controllers;


import org.launchcode.amenti.models.Supplement;
import org.launchcode.amenti.models.SupplementsType;
import org.launchcode.amenti.models.User;
import org.launchcode.amenti.models.data.SupplementsDao;
import org.launchcode.amenti.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("amenti")
public class SupplementsController {

    @Autowired
    SupplementsDao supplementsDao;


    @RequestMapping(value = "")
    public String index(Model model, @ModelAttribute User user) {
            model.addAttribute("supplements", supplementsDao.findAll());
            model.addAttribute("title", "Amenti");
            model.addAttribute("user", user);
            return "amenti/index";
        }

    @RequestMapping(value = "/supplements/{typeId}")
    public String displaySupplementType(Model model, @PathVariable String typeId) {
        SupplementsType supplementsType = SupplementsType.valueOf(typeId.toUpperCase());
        model.addAttribute("supplements", supplementsDao.findByType(supplementsType));
        model.addAttribute("title", "Amenti");
        return "amenti/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddSupplementForm(Model model) {

        model.addAttribute("title", "Add a New Supplement");
        model.addAttribute(new Supplement());
        model.addAttribute("supplementsType", SupplementsType.values());

        return "amenti/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddSupplementForm(@ModelAttribute @Valid Supplement newSupplement,
                                           Model model, User user, Errors errors, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("user");
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a New Supplement");
            model.addAttribute("supplementsType", SupplementsType.values());
            return "amenti/add";
        }
        newSupplement.setUser(loggedInUser);
        supplementsDao.save(newSupplement);

        return "redirect:";
    }
}

