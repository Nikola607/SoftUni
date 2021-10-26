package com.example.battleships.web;

import com.example.battleships.models.view.ShipViewModel;
import com.example.battleships.security.CurrentUser;
import com.example.battleships.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private CurrentUser currentUser;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @GetMapping()
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        List<ShipViewModel> shipViewModelList = shipService.findAllShips();
        List<ShipViewModel> loggedInShips = shipService.findAllLoggedInShips(currentUser.getId());

        model.addAttribute("ships", shipService.findAllShips());
        model.addAttribute("health", shipViewModelList
                .stream()
                .map(ShipViewModel::getHealth));
        model.addAttribute("power", shipViewModelList
                .stream()
                .map(ShipViewModel::getPower));
        model.addAttribute("loggedInShips", loggedInShips);

        return "home";
    }
}
