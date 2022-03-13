package com.santhosh.coronavirustracker.controllers;

import com.santhosh.coronavirustracker.models.LocationStats;
import com.santhosh.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;
    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats= coronaVirusDataService.getAllStats();
        long totalReportedCases=0;
        for(int i=0;i<allStats.size();i++)
        {
            totalReportedCases+=allStats.get(i).getLatestTotalCases();
        }
        model.addAttribute("locationStats",coronaVirusDataService.getAllStats());
        model.addAttribute("totalReportedCases",totalReportedCases);
        return "home";
    }
}
