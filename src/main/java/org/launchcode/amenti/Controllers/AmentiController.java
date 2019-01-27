package org.launchcode.amenti.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
@RequestMapping("amenti")
public class AmentiController {

    static ArrayList<String> sups = new ArrayList<>();

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
    public String processAddFavoriteForm(@RequestParam String supName) {

        sups.add(supName);
        //redirect to /amenti
        return "redirect:";
    }


}

