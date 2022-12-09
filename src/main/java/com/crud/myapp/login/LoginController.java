package com.crud.myapp.login;

import com.crud.myapp.user.UserServiceImpl;
import com.crud.myapp.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    UserServiceImpl service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String t, Model model) {
        return "loginform";
    }

    // 로그인하는 과정
    @RequestMapping(value = "/loginOk", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo) {
        String returnURL = "";
        if (session.getAttribute("login") != null) {
            session.removeAttribute("login");
        }

        UserVO loginvo = service.getUser(vo);
        if (loginvo != null) { // 로그인 성공
            System.out.println("로그인 성공!");
            session.setAttribute("login", loginvo);
            return "redirect:/board/list";
        } else {
            System.out.println("로그인 실패!");
            returnURL = "redirect:/login/login";
        }
        return returnURL;
    }

    // 로그아웃 하는 부분
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션에 있는 모든 정보 무효화
        return "redirect:/login/login";
    }
}
