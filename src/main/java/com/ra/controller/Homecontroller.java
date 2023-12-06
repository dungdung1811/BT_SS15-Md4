package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Homecontroller {
    @Autowired
    UserSevice userSevice;

    @RequestMapping(value = {"", "/home"})
    public String home() {
        return "home";
    }


    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String create(@ModelAttribute("user") User user,
                         RedirectAttributes redirectAttributes) {
        userSevice.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model,@CookieValue(required = false,name ="email") String emailCookie) {
        User user = new User();
        if(emailCookie != null){
            user.setEmail(emailCookie);
            model.addAttribute("checked",true);
        }
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") User user,
                            HttpSession httpSession,
                            RedirectAttributes redirectAttributes,
                            @RequestParam(required = false,name ="checked") Boolean isCheck,
                            HttpServletRequest request,
                            HttpServletResponse response){
        User user1 = userSevice.login(user);
        Cookie cookie = new Cookie("email", user.getEmail());
        if (user1 != null) {
            httpSession.setAttribute("name", user1.getUserName());
            if(isCheck != null){
//            khoi tao cookie
//            set thoi gian ton tai
                cookie.setMaxAge(24*60*60);
//            nho respon de gui cookie tu server ve clien
                response.addCookie(cookie);
            } else {
                Cookie [] cookies = request.getCookies();
                for (Cookie c:cookies) {
                    if (  c.getName().equals("email")){
                        c.setMaxAge(0);
                        response.addCookie(c);
                        break;
                    }
                }
            }

            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("err", "Sai mk, hoac email");
        return "redirect:/login";
    }



    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("name");
        return "redirect:/home";
    }

}
