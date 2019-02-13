package org.launchcode.amenti.controllers;


import org.launchcode.amenti.models.SupplementModel;
import org.launchcode.amenti.models.SupplementsType;
import org.launchcode.amenti.models.data.SupplementsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import javax.validation.Valid;

@Controller
@RequestMapping("amenti")
public class SupplementsController {

    @Autowired
    SupplementsDao supplementsDao;


    //request path: /amenti
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("sups", supplementsDao.findAll());
        model.addAttribute("title", "Amenti");
        return "amenti/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddSupplementForm(Model model) {

        model.addAttribute("title", "Add a New Supplement");
        model.addAttribute(new SupplementModel());
        model.addAttribute("supplementsType", SupplementsType.values());

        return "amenti/add";

    }

    //needs to save the item to the logged in users table
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddSupplementForm(@ModelAttribute @Valid SupplementModel newSupplement,
                                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a New Supplement");
            model.addAttribute("supplementsType", SupplementsType.values());
            return "amenti/add";
        }



        supplementsDao.save(newSupplement);
        //redirect to home
        return "redirect:";
    }

    //needs an html form page
    /**@RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveSupplementsForm(Model model) {

        model.addAttribute("sups", supplementsDao.findAll());
        model.addAttribute("title", "Remove a favorite");
        return "amenti/remove";
    }*/

    /**@RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveSupplementForm(@RequestParam int[] supsIds) {

        for(int supsId : supsIds) {
            supplementsDao.delete(supsId);
        }

        return "redirect:";
    }*/




}

