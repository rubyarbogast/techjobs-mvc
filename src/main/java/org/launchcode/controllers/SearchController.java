package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    /** TODO #1 - Create handler to process search request and display results
     * features must be named based on corresponding form field names
     * use the correct annotations for the method and parameters
     * refer to the form action in search.html to configure the correct mapping route
     * after looking up search results via JobData class, pass them into search.html view via the model
     * pass ListController.columnChoices to the view, as existing search handler does
     */
}
