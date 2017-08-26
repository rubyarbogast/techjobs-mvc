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
        String searchType = "all"; //so that all columns will be searched if nothing else is selected

        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("searchType", searchType);
        return "search";
    }

    /** TODO #1 - Create handler to process search request and display results
     * should take 2 parameters: type of search and search term
     * features must be named based on corresponding form field names
     * use the correct annotations for the method and parameters
     * refer to the form action in search.html to configure the correct mapping route
     * after looking up search results via JobData class, pass them into search.html view via the model
     * pass ListController.columnChoices to the view, as existing search handler does
     * say number of results
     */
    //TODO:
    // RequestMapping value should be search/results
    // search term is searchTerm; type is searchType
    // method should be get
    // use if/else -- if the search is in all columns (findByValue), else if search is in a specific column (findByColumnAndValue)

    //searchType says which column to search

    @RequestMapping(value="results")
    public String search(Model model,
                         @RequestParam String searchTerm, @RequestParam String searchType) {
        // look up the search results via the JobData class -- use findByValue
        ArrayList<HashMap<String, String>> jobs;

        if(searchType.equals("all")) {
            jobs = JobData.findByValue(searchTerm);
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        System.out.println(searchType);

        // pass to search view:
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobs", jobs);
        model.addAttribute("searchType", searchType);
        return "search";

    }

}
