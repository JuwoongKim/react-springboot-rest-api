package com.juwoong.reactspringbootrestapi.pockets.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juwoong.reactspringbootrestapi.pockets.service.PocketService;
import com.juwoong.reactspringbootrestapi.pockets.service.dto.PocketsDto;

@Controller
@RequestMapping("/api/pocket")
public class PocketsController {

    private final PocketService pocketService;

    public PocketsController(PocketService pocketService) {
        this.pocketService = pocketService;

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<PocketsDto>> listByUser(@PathVariable("id") UUID id) {
        List<PocketsDto> response = pocketService.findByUserId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") UUID id) {
        pocketService.deleteByUserId(id);

        return ResponseEntity.ok(id);
    }




}
