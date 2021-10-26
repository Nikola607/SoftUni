package com.example.battleships.web;

import com.example.battleships.models.binding.ShipAddBindingModel;
import com.example.battleships.models.service.ShipServiceModel;
import com.example.battleships.services.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    private String add(){
        return "ship-add";
    }

    @PostMapping("/add")
    private String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirect){

        if (bindingResult.hasErrors()) {
            redirect.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);

            return "redirect:add";
        }

        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/fire/{id}")
    private String fire(@PathVariable Long id){
        shipService.fire(id);

        return "redirect:/";
    }

    @ModelAttribute
    private ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }
}
