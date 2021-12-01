package personal.project.two_vago.web;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import personal.project.two_vago.models.binding.OfferAddBindingModel;
import personal.project.two_vago.models.binding.OfferUpdateBindingModel;
import personal.project.two_vago.models.entities.enums.CategoryNameEnum;
import personal.project.two_vago.models.entities.enums.CityNameEnum;
import personal.project.two_vago.models.entities.view.OfferDetailsView;
import personal.project.two_vago.models.service.OfferServiceModel;
import personal.project.two_vago.service.OfferService;
import personal.project.two_vago.service.impl.TwoVagoUser;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value = "/offers")
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
                                  BindingResult bindingResult, RedirectAttributes redirect,
                                  @AuthenticationPrincipal TwoVagoUser user) {

        if (bindingResult.hasErrors()) {
            redirect.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);
            redirect.addFlashAttribute("brandsModels", offerService.getAllOffers());
            return "redirect:/add";
        }

        OfferServiceModel offerServiceModel = offerService.addOffer(offerAddBindingModel, user.getUserIdentifier());

        return "redirect:/" + offerServiceModel.getId() + "/details";
    }

    @PreAuthorize("isOwnerUpdate(#id)")
    @GetMapping("/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model,
                            @AuthenticationPrincipal TwoVagoUser currentUser) {

        OfferDetailsView offerDetailsView = offerService.findById(id, currentUser.getUserIdentifier());
        OfferUpdateBindingModel offerModel = modelMapper.map(
                offerDetailsView,
                OfferUpdateBindingModel.class
        );
        model.addAttribute("cities", CityNameEnum.values());
        model.addAttribute("categories", CategoryNameEnum.values());
        model.addAttribute("offerModel", offerModel);
        return "update";
    }

    @PreAuthorize("isOwnerUpdate(#id)")
    @PatchMapping("/{id}/edit")
    public String editOffer(
            @PathVariable Long id,
            @Valid OfferUpdateBindingModel offerModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/" + id + "/edit/errors";
        }

        OfferServiceModel serviceModel = modelMapper.map(offerModel,
                OfferServiceModel.class);
        serviceModel.setId(id);

        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }

    @PreAuthorize("isOwner(#id)")
    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable Long id,
                              Principal principal) {

        // Most naive approach - check explicitly if the current user is an
        //owner and throw exception if this is not the case.
//        if (!offerService.isOwner(principal.getName(), id)) {
//            throw new RuntimeException();
//        }
        offerService.deleteOffer(id);

        return "redirect:all";
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
