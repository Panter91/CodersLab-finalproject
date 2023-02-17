package pl.coderslab.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.dto.TeamDTO;
import pl.coderslab.finalproject.entity.Team;
import pl.coderslab.finalproject.service.TeamService;

@RequestMapping("/team")
@Controller
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> get(@PathVariable Long id){
        return ResponseEntity.of(teamService.get(id));
    }
    @GetMapping("/create-team")
    public String getTeam(Model model){
        model.addAttribute("newTeam", new TeamDTO());
        return "create-team";
    }

    @PostMapping("/create-team")
    public String addTeam(@ModelAttribute TeamDTO teamDTO) {
        teamService.save(teamDTO);
        return "redirect:/home-page";
    }
}