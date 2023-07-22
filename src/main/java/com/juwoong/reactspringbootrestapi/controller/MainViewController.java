package com.juwoong.reactspringbootrestapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juwoong.reactspringbootrestapi.content.service.ContentService;
import com.juwoong.reactspringbootrestapi.content.service.dto.ContentDto;
import com.juwoong.reactspringbootrestapi.user.service.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainViewController {

    private final ContentService contentService;

    public MainViewController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping(value = {"/", "/index", "/main"})
    public String index(Model model) {
        List<ContentDto> contentList = contentService.getContents();
        model.addAttribute("contentList", contentList);

        return "main";
    }

    @GetMapping("/mainLogin")
    public String mainLogin (Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            UserDto user = (UserDto) session.getAttribute("user");

            model.addAttribute("user", user);
            List<ContentDto> contentList = contentService.getContents();
            model.addAttribute("contentList", contentList);

            return "main-login";
        } else {
            return "main";
        }

    }


    @GetMapping("/admin")
    public String admin( Model model) {
        List<ContentDto> contentList = contentService.getContents();
        model.addAttribute("contentList", contentList);

        return "admin";
    }







}
