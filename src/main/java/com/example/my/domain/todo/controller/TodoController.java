package com.example.my.domain.todo.controller;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.config.security.auth.CustomUserDetails;
import com.example.my.domain.todo.dto.ResTodoTableDTO;
import com.example.my.domain.todo.service.TodoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping({"", "/"})
    public ModelAndView todoTablePage(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        ModelAndView modelAndView = new ModelAndView();

//        if (session.getAttribute("loginUserDTO") == null) {
//            modelAndView.setViewName("redirect:/auth/login");
//            return modelAndView;
//        }

//        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("loginUserDTO");


        ResTodoTableDTO dto = todoService.getTodoTableData(customUserDetails.getLoginUserDTO());
        modelAndView.addObject("dto", dto);
        modelAndView.setViewName("todo/table");
        return modelAndView;
    }

}
