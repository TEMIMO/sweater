package com.example.sweater.contoller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user") // Чтобы у каждого метода не подписывать, что он содержит в своем путь /user
public class UserController {
    @Autowired
    private UserSevice userSevice;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userSevice.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){ // PathVariable - для работы с параметром в адрее запроса (Для User user Spring намного умнее и понимают как брать User о ID)
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){

        userSevice.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){ // Получаем пользователя из контекста, не обращаясь к бд
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ){

        userSevice.updateProfile(user, password, email);


        return "redirect:/user/profile";
    }

}
