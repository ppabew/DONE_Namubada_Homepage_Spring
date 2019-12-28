package com.mycom.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes({"sessionID","sessionNICK"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/insertUser.do")
    public String insertUser(UserVO vo, Model model){
        System.out.println("===>Controller로 insertUser() 기능 처리");
        userService.insertUser(vo);
        UserVO userInfo = userService.getUser(vo);
        model.addAttribute("sessionID", userInfo.getId());
        model.addAttribute("sessionNICK",userInfo.getNick());

        return "/index.jsp";
    }

    @RequestMapping(value = "/getListUser.do")
    public String getListUser(Model model1, Model model2){
        System.out.println("===>Controller로 getListUser() 기능 처리");
        model1.addAttribute("listUser",userService.getListUser());
        model2.addAttribute("countUser",userService.getCountUser());
        return "/user/joinForm.jsp";
    }

    @RequestMapping(value = "/getListUserLogin.do")
    public String getListUser(Model model){
        System.out.println("===>Controller로 getListUser() 기능 처리");
        model.addAttribute("listUser",userService.getListUser());
        return "/user/loginForm.jsp";
    }

    @RequestMapping(value = "/loginUser.do")
    public String loginUser(UserVO vo,  Model model){
        System.out.println("===>Controller로 loginUser() 기능 처리 및 세션처리");
        UserVO userInfo = userService.getUser(vo);

        model.addAttribute("sessionID", userInfo.getId());
        model.addAttribute("sessionNICK",userInfo.getNick());

        return "/index.jsp";
    }

    @RequestMapping(value = "/logoutUser.do")
    public String logoutUser(SessionStatus sessionStatus){
        System.out.println("===>Controller로 logoutUser() 기능 처리 및 세션 삭제");
        sessionStatus.setComplete();
        System.out.println("삭제완료");
        return "redirect:/index.jsp";
    }
}
