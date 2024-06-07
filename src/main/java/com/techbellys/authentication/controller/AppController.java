package com.techbellys.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public String home() {
        return "Home page";
    }
    @GetMapping("/store")
    public String store() {
        return "Store page";
    }
    @GetMapping("/admin/home")
    public String getAdminHome() {
        return "Admin Home Page";
    }
    @GetMapping("/client/home")
    public String getClientHome() {
        return "Cleint Home Page";
    }
}

