package com.app.ReviewHub.Controller;

import com.app.ReviewHub.Model.Dto.PersonRequest;
import com.app.ReviewHub.Model.Dto.User.UserResponse;
import com.app.ReviewHub.Model.Enum.Role;
import com.app.ReviewHub.Services.Interface.User_S_Interface;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final User_S_Interface userService;

    @GetMapping
    public String signUp() {
        PersonRequest user = new PersonRequest();
        user.setRole(Role.Admin);
        user.setEmail("elbakkouri@gmail.com");
        user.setAddress("Taounate Ahsan address");
        user.setDateOfBirth(LocalDate.now());
        user.setFullName("alo");
        user.setPassword(passwordEncoder.encode("12345"));
        userService.save(user);
        return "login";
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable UUID id) {
        return userService.find(id);
    }
}
