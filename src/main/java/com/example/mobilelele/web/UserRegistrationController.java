package com.example.mobilelele.web;

import com.example.mobilelele.model.dto.UserRegistrationDTO;
import com.example.mobilelele.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/users") //и двата метода --> /users
@Controller
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("createOfferDTO", userRegistrationDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO",
                            bindingResult);

            return "redirect:/users/register";
        }

        userService.registerUser(userRegistrationDTO);

        return "redirect:/users/login";
    }

}
