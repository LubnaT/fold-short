package com.carresearch.controller;

import com.carresearch.dto.CarResponse;
import com.carresearch.dto.ShortlistRequest;
import com.carresearch.service.ShortlistService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shortlist")
public class ShortlistController {

    private final ShortlistService shortlistService;

    public ShortlistController(ShortlistService shortlistService) {
        this.shortlistService = shortlistService;
    }

    @PostMapping
    public List<CarResponse> saveShortlist(@Valid @RequestBody ShortlistRequest request) {
        return shortlistService.saveShortlist(request);
    }

    @GetMapping
    public List<CarResponse> getShortlist() {
        return shortlistService.getShortlist();
    }
}
