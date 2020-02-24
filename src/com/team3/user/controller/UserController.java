package com.team3.user.controller;

import com.team3.user.service.UserInsertService;
import com.team3.user.service.UserSelectService;
import com.team3.user.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.user")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        String view = null; //jsp파일의 경로주소
        UserServiceImpl service = null;

        if(uri.equals("/user/user_join.user")) {
            service = new UserInsertService();
            service.execute(request, response);
            view = "/user/user_join_ok.jsp";
        } else if(uri.equals("/user/user_login.user")) {
            service = new UserSelectService();
            service.execute(request, response);
            view = "/user/user_login_ok.jsp";
        } else if(uri.equals("")) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
