package personal.project.two_vago.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import personal.project.two_vago.models.binding.OfferAddBindingModel;
import personal.project.two_vago.models.service.OfferServiceModel;
import personal.project.two_vago.service.OfferService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final ModelMapper modelMapper;
    private final OfferService offerService;

    public OfferController(ModelMapper modelMapper, OfferService offerService) {
        this.modelMapper = modelMapper;
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String addOffer() {
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOfferConfirm(@Valid OfferAddBindingModel offerAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirect) {

        if (bindingResult.hasErrors()) {
            redirect.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);

            return "redirect:add";
        }

        offerService.addOffer(modelMapper
                .map(offerAddBindingModel, OfferServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",
                offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/{id}/details")
    public String showOffer(
            @PathVariable Long id, Model model,
            Principal principal) {
        model.addAttribute("offer", this.offerService.findById(id, principal.getName()));
        return "details";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }
}
