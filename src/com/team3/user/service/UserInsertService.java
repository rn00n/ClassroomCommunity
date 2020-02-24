package com.team3.user.service;

import com.team3.user.model.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInsertService implements UserServiceImpl {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pw = request.getParameter("pw");
        String phone = request.getParameter("phone");
        UserDAO dao = UserDAO.getInstance();

        dao.insert(id, name, pw, phone);
    }
}
