package pl.coderslab.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.service.MatchService;
import pl.coderslab.finalproject.service.TeamSummaryService;

@RequestMapping("/summary")
@Controller
public class TeamSummaryController {

    private final TeamSummaryService teamSummaryService;
    private final MatchService matchService;

    @Autowired
    public TeamSummaryController(TeamSummaryService teamSummaryService, MatchService matchService) {
        this.teamSummaryService = teamSummaryService;
        this.matchService = matchService;
    }

    @GetMapping("/table")
    public String getTable(Model model) {
        model.addAttribute("teamsummaries", teamSummaryService.find());
        return "result-table";
    }

}
