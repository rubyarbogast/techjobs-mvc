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

    @RequestMapping(value="results")
    public String search(Model model,
                         @RequestParam String searchTerm, @RequestParam String searchType) {
        ArrayList<HashMap<String, String>> jobs;

        // if the search is in all columns, look up results via findByValue,
        // else search is in a specific column, use findByColumnAndValue
        // either way, add the jobs found to the ArrayList of jobs
        if(searchType.equals("all")) {
            jobs = JobData.findByValue(searchTerm);
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        // pass search results found above to search view:
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobs", jobs);
        // pass searchType back to the view so that the user's column selection will stay selected
        model.addAttribute("searchType", searchType);
        return "search";

    }

}
