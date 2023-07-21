package com.juwoong.reactspringbootrestapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juwoong.reactspringbootrestapi.content.service.dto.ContentDto;
import com.juwoong.reactspringbootrestapi.pockets.service.PocketService;
import com.juwoong.reactspringbootrestapi.pockets.service.dto.PocketsDto;

@Controller
@RequestMapping("/pocket")
public class PocketViewController {

    private final PocketService pocketService;

    public PocketViewController(PocketService pocketService) {
        this.pocketService = pocketService;

    }

    @GetMapping("/list/{id}")
    public String listByUser(@PathVariable("id") UUID id , Model model ){
        List<PocketsDto> pockets = pocketService.findByUserId(id);
        model.addAttribute("pocket", pockets );

        return "pocket/my";
    }

}
