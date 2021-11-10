package personal.project.two_vago.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import personal.project.two_vago.models.binding.UserLoginBindingModel;
import personal.project.two_vago.models.binding.UserRegisterBindingModel;
import personal.project.two_vago.models.service.UserServiceModel;
import personal.project.two_vago.security.CurrentUser;
import personal.project.two_vago.service.UserService;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/";
    }

    @GetMapping("/profile")
    private String profile(){
        return "profile";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirect) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {

            redirect.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.    registerUser(modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @PostMapping("/login")
    public String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            redirect.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirect.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirect.addFlashAttribute("isFound", false);
            return "redirect:login";
        }

        userService.login(userServiceModel.getId(), userServiceModel.getFullName(),
                userLoginBindingModel.getRole());

        return "redirect:/";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}
