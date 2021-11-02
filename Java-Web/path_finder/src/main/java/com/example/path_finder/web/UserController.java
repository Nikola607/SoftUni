package com.example.path_finder.web;

import com.example.path_finder.models.enities.binding.UserLoginBindingModel;
import com.example.path_finder.models.enities.binding.UserRegisterBindingModel;
import com.example.path_finder.models.enities.service.UserServiceModel;
import com.example.path_finder.service.UserService;
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
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    private String login(){
        return "login";
    }

    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping("/register")
    private String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                   BindingResult bindingResult, RedirectAttributes redirect){

        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())){

            redirect.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        userService
                .registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:login";
    }

    @PostMapping("/login")
    private String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirect){

        if(bindingResult.hasErrors()){
            redirect.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if(userServiceModel == null){
            redirect.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirect.addFlashAttribute("isFound", false);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(), userLoginBindingModel.getUsername());

        return "redirect:/";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public  UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }
}
