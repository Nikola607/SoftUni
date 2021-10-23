package com.example.music.web;

import com.example.music.model.binding.AlbumAddBindingModel;
import com.example.music.model.service.AlbumServiceModel;
import com.example.music.services.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumsController {
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumsController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AlbumAddBindingModel albumAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirect){

        if (bindingResult.hasErrors()) {
            redirect.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);

            return "redirect:add";
        }

        albumService.addAlbum(modelMapper
        .map(albumAddBindingModel, AlbumServiceModel.class));

        return "redirect:/";
    }

    @ModelAttribute
    public AlbumAddBindingModel albumAddBindingModel(){
        return new AlbumAddBindingModel();
    }
}
