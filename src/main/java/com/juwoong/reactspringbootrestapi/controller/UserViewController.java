package com.juwoong.reactspringbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.juwoong.reactspringbootrestapi.user.service.UserService;
import com.juwoong.reactspringbootrestapi.user.service.dto.UserDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserViewController {

    private final UserService userService;

    public UserViewController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String loginUser() {
        //UserDto response = userService.createUser(request);

        return "user/login-form";
    }


    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {

        try{
            UserDto user = userService.login(email, password);
            session.setAttribute("user", user);

            return "redirect:/mainLogin";
        } catch (Exception e){
            model.addAttribute("error", "Invalid credentials");

            return "user/login-error";
        }

    }

    // @PostMapping("/login")
    // public ResponseEntity<UserDto> createUser(@RequestBody UserRequest.Create request) {
    //     UserDto response = userService.createUser(request);
    //
    //     "redirect:/customer/list";
    //
    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // }

    //
    // @GetMapping("/create")
    // public String create() {
    //     return "customer/customer-form";
    // }
    //
    // @PostMapping("/create")
    // public String save(@ModelAttribute CustomerCreateRequestDto customerCreateRequestDto) {
    //     customerService.save(customerCreateRequestDto);
    //
    //     return "redirect:/customer/list";
    // }



}
