package ru.safin.githubparsing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.safin.githubparsing.model.Follower;
import ru.safin.githubparsing.service.FollowerService;

import java.util.List;

@Controller
public class MainController {

    private final FollowerService followerService;

    @Autowired
    public MainController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping(value = {"/search", "/"})
    public String mainPage(Model model, @RequestParam("query") String query) {
        model.addAttribute("followers", followerService.getFollowers(query));
        model.addAttribute("query", query);
        return "index";
    }

}
