package com.juwoong.reactspringbootrestapi.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.juwoong.reactspringbootrestapi.content.controller.request.ContentRequest;
import com.juwoong.reactspringbootrestapi.content.model.Content;
import com.juwoong.reactspringbootrestapi.content.model.constants.ContentType;
import com.juwoong.reactspringbootrestapi.content.service.ContentService;
import com.juwoong.reactspringbootrestapi.content.service.dto.ContentDto;

@Controller
@RequestMapping("/content")
public class ContentViewController {
    private final ContentService contentService;

    public ContentViewController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        ContentDto response = contentService.findById(id);

        ContentDto content = contentService.findById(id);
        model.addAttribute("content", content);

        return "content/content-detail";
    }

    @GetMapping("/new")
    public String createContent(Model model) {
        model.addAttribute("content", new Content());
        return "/content-form";
    }

    @PostMapping("/new")
    public String createContent(@RequestParam("title") String title,
        @RequestParam("text") String text,
        @RequestParam("contentType") ContentType contentType,
        @RequestParam("price") long price, Model model) {

        ContentRequest.Create request = new ContentRequest.Create(title, text, contentType, price);

        ContentDto response = contentService.createContent(request);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editContent(@PathVariable("id") UUID id, Model model) {

        ContentDto response = contentService.findById(id);

        model.addAttribute("content", response);

        return "/content-update";
    }

    @PostMapping("/update")
    public String editContent(@RequestParam("contentId") String contentId,
        @RequestParam("title") String title,
        @RequestParam("text") String text,
        @RequestParam("contentType") ContentType contentType,
        @RequestParam("price") long price, Model model) {

        ContentRequest.Update request = new ContentRequest.Update(UUID.fromString(contentId), title, text, contentType,
            price);
        try{
            ContentDto response = contentService.update(request);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String listByUser(@PathVariable("id") UUID id) {
        contentService.deleteById(id);

        return "redirect:/admin";
    }

}
