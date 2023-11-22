package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class Homecontroller {
    @Autowired
    UserSevice userSevice;

    @RequestMapping(value = {"", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    @PostMapping("/login")
    public String postLogin (@ModelAttribute("user")User user, HttpSession httpSession, RedirectAttributes redirectAttributes){
      if(userSevice.login(user)){
          httpSession.setAttribute("email",user.getEmail());
          return "redirect:/home";
      }
      redirectAttributes.addFlashAttribute("err","Sai mk, hoac email");
        return  "redirect:/login";
    }
}
