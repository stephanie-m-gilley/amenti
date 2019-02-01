package org.launchcode.amenti.controllers;


import org.launchcode.amenti.models.Supplements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;



@Controller
@RequestMapping("amenti")
public class AmentiController {

    static ArrayList<Supplements> sups = new ArrayList<>();

    //request path: /amenti. This is the welcome page after logging in
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("sups", sups);
        model.addAttribute("title", "Amenti");
        return "amenti/index";
    }

    @RequestMapping(value = "add")
    public String displayAddFavoriteForm(Model model) {
        model.addAttribute("title", "Add a New Supplement");
        return "amenti/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddFavoriteForm(@RequestParam String supName, @RequestParam String supDescription) {
        Supplements newSupplement = new Supplements(supName, supDescription);
        sups.add(newSupplement);
        //redirect to /amenti
        return "redirect:";
    }

    //@RequestMapping(value = "remove", method = RequestMethod.GET)
    //public String processRemoveFavorite(Model model) {
      //  model.addAttribute("")
   // }

}

