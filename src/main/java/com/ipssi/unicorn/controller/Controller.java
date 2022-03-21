package com.ipssi.unicorn.controller;


import com.ipssi.unicorn.ressources.RestUnicorn;
import com.ipssi.unicorn.service.Display;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Display display;

    @GetMapping("/unicorns")
    public List<RestUnicorn> getAllUnicorns() {
        return display.getUnicorns();
    }
}
