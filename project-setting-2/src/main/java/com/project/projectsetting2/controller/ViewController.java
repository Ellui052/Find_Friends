package com.project.projectsetting2.controller;

import com.project.projectsetting2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class ViewController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/noticeboard")
    public String noticeboardPage(Model mv) {
        mv.addAttribute("boards", userService.getBoards());
        return "noticeboard";
    }

    @GetMapping("/board")
    public String getBoardById(@RequestParam Long id, Model mv) {
        mv.addAttribute("board", userService.getBoardById(id));
        return "detail";
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam(required = false) String keyword, Model model) {
        if (keyword == null || !keyword.isEmpty()) {
            model.addAttribute("boards", userService.getBaordByKeword(keyword));
        }
        return "search";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/write")
    public String writePage() {
        return "write";
    }

}
