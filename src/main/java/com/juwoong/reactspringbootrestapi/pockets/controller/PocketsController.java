package com.juwoong.reactspringbootrestapi.pockets.controller;

import org.springframework.stereotype.Controller;

import com.juwoong.reactspringbootrestapi.pockets.service.PocketService;

@Controller
public class PocketsController {

    private final PocketService pocketService;

    public PocketsController(PocketService pocketService) {
        this.pocketService = pocketService;

    }


}
