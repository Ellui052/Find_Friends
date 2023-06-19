package com.project.projectsetting2.controller;

import com.project.projectsetting2.dto.*;
import com.project.projectsetting2.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final UserService userService;

    @PostMapping("/join")
    public String join(MemberJoinDto dto) {
        userService.join(dto);
        return "login";
    }

    @PostMapping("/board/write")
    public String writeBoard(BoardWriteDto dto, Principal principal) {
        userService.writeBoard(dto, principal);
        return "redirect:/view/noticeboard";
    }

    @PostMapping("/board/delete")
    public String writeBoard(BoardDeleteDto dto) {
        userService.deleteBoard(dto);
        return "redirect:/view/noticeboard";
    }

    @PostMapping("/user/change/nickname")
    public String changeNickname(ChangeNicknameDto dto, Principal principal) {
        userService.changeNickname(dto, principal);
        return "redirect:/view/noticeboard";
    }

    @PostMapping("/user/change/password")
    public String changePassword(ChangePasswordDto dto, Principal principal, HttpSession session) {
        boolean isValid = userService.changePassword(dto, principal);
        if (isValid) {
            session.invalidate();
            return "login";
        } else {
            return "noticeboard";
        }
    }

}
