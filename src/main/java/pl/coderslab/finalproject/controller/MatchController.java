package pl.coderslab.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.dto.MatchDTO;
import pl.coderslab.finalproject.dto.MatchResultDTO;
import pl.coderslab.finalproject.entity.Match;
import pl.coderslab.finalproject.service.MatchService;

import java.util.List;

@RequestMapping("/match")
@Controller
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

//    @GetMapping("/list")
//    public List<MatchDTO> findAllByFinished(@RequestParam boolean finished){
//        return matchService.findAllByFinished(finished);
//    }

    @GetMapping("/generate")
    public String schedule(){

        return "home-page";
    }

    @GetMapping("/list")
    public String listOfMatches(Model model, @RequestParam boolean finished){
        model.addAttribute("matches", matchService.findAllByFinished(finished));
        return finished ? "finished-matches-list" : "matches-list";
    }

    @GetMapping("/match-update/{id}")
    public String matchToUpdate(Model model, @PathVariable Long id){
        MatchDTO matchDTO = matchService.findMatchById(id);
        model.addAttribute("match", matchDTO);
        return "match-detail";
    }

    @PostMapping("/match-update/{id}")
    public String matchUpdateForm(MatchDTO matchDTO){
        matchService.updateresult(matchDTO);
        return "redirect:/match/list?finished=true";
    }

    @PostMapping("/generate")
    public String generateSchedule() {
        matchService.generateSchedule();
        return "redirect:/home-page";
    }


//    @GetMapping("/matches")
//    public String getTeam(Model model){
//        model.addAttribute("newTeam", new TeamDTO());
//        return "home-page";
//    }
//
//
//    @PostMapping("/create-team")
//    public String addTeam(@ModelAttribute TeamDTO teamDTO) {
//
//        return "redirect:/home-page";
//    }
}
