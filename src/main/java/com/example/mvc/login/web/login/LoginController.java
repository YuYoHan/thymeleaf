package com.example.mvc.login.web.login;

import com.example.mvc.login.domain.login.LoginService;
import com.example.mvc.login.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Log4j2
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    @PostMapping("/lgoin")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult result) {
        if(result.hasErrors()) {
            return "lgoin/loginForm";
        }
        Member login = loginService.login(form.getLoginId(), form.getPassword());
        if(login == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        // 로그인 성공
        return "redirect:/";
    }
}
