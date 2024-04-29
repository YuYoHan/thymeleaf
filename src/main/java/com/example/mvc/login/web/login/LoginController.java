package com.example.mvc.login.web.login;

import com.example.mvc.login.domain.login.LoginService;
import com.example.mvc.login.domain.member.Member;
import com.example.mvc.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Log4j2
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

//    @PostMapping("/lgoin")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult result, HttpServletResponse response) {
        if(result.hasErrors()) {
            return "lgoin/loginForm";
        }
        Member login = loginService.login(form.getLoginId(), form.getPassword());
        if(login == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        // 로그인 성공 처리
        // 쿠키에 시간 정보를 주지 않으면 세션 쿠기(브라우저 종료시 모두 종료)
        Cookie idCookie = new Cookie("memberId", String.valueOf(login.getId()));
        response.addCookie(idCookie);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logOut(HttpServletResponse response) {
        expireCookie(response, "memberId");
        return "redirect:/";
    }

    // 쿠키 설정한 것을 로그아웃하려면 시간을 0으로 하면 된다.
    private static void expireCookie(HttpServletResponse response,
                                     String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @PostMapping("/lgoin")
    public String loginV2(@Valid @ModelAttribute LoginForm form,
                          BindingResult result,
                          HttpServletResponse response) {
        if(result.hasErrors()) {
            return "lgoin/loginForm";
        }
        Member login = loginService.login(form.getLoginId(), form.getPassword());
        if(login == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        // 로그인 성공 처리
        // 세션 관리자를 통해 세션을 생성하고 회원 데이터를 보관
        sessionManager.createSession(login, response);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logOutV2(HttpServletRequest request) {
        sessionManager.expire(request);
        return "redirect:/";
    }
}
