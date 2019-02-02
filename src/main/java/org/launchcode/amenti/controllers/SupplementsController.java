package org.launchcode.amenti.controllers;


import org.launchcode.amenti.models.Supplements;
import org.launchcode.amenti.models.data.SupplementsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("amenti")
public class SupplementsController {

    @Autowired
    private SupplementsDao supplementsDao;

    //request path: /amenti. This is the welcome page after logging in
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("sups", supplementsDao.findAll());
        model.addAttribute("title", "Amenti");
        return "amenti/index";
    }
    //needs finishing to add a supplement
    @RequestMapping(value = "add")
    public String displayAddFavoriteForm(Model model) {
        model.addAttribute("title", "Add a New Supplement");

        return "amenti/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddFavoriteForm(@RequestParam String supName, @RequestParam String supDescription) {
        Supplements newSupplement = new Supplements(supName, supDescription);
        supplementsDao.save(newSupplement);
        //redirect to /amenti
        return "redirect:";
    }


}
