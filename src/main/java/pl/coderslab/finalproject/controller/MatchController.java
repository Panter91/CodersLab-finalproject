package pl.coderslab.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.dto.MatchDTO;
import pl.coderslab.finalproject.service.MatchService;

@RequestMapping("/match")
@Controller
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/list")
    public String listOfMatches(Model model, @RequestParam boolean finished) {
        model.addAttribute("matches", matchService.findAllByFinished(finished));
        return finished ? "finished-matches-list" : "matches-list";
    }

    @GetMapping("/match-update/{id}")
    public String matchToUpdate(Model model, @PathVariable Long id) {
        MatchDTO matchDTO = matchService.findMatchById(id);
        model.addAttribute("match", matchDTO);
        return "match-detail";
    }

    @PostMapping("/match-update/{id}")
    public String matchUpdateForm(MatchDTO matchDTO) {
        matchService.updateResult(matchDTO);
        return "redirect:/match/list?finished=true";
    }

    @PostMapping("/generate")
    public String generateSchedule() {
        matchService.generateSchedule();
        return "redirect:/home-page";
    }
}
