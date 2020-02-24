package com.team3.user.service;

import com.team3.user.model.UserDAO;
import com.team3.user.model.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSelectService implements UserServiceImpl{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        UserDAO dao = UserDAO.getInstance();

        UserDTO dto = dao.select(id);
        System.out.println(dto.getId());
        System.out.println(dto.getName());
        System.out.println(dto.getPw());
        System.out.println(dto.getPhone());

        request.setAttribute("user_login", dto);
    }
}
