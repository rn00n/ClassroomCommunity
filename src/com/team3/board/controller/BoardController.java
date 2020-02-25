package com.team3.board.controller;

import com.team3.board.service.*;
import com.team3.user.service.UserInsertService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }
    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        BoardServiceImpl service = null;
        String view = null; //jsp파일의 경로주소

        String uri = request.getRequestURI();
//        String conPath = request.getContextPath();
//        System.out.println("conPath" + conPath);
//        String com = uri.substring(conPath.length());
//        System.out.println("com" + com);


        if(uri.equals("/board/board_insert.board")) {
            service = new BoardInsertService();
            service.execute(request, response);
            view = "/board/board_list.board";
        } else if(uri.equals("/board/board_answer_content.board")) {
            service = new BoardContentService();
            service.execute(request, response);
            view = "/board/board_answer_content.jsp";
        } else if(uri.equals("/board/board_answer_insert.board")) {
            System.out.println("1");
            service = new BoardAnswerInsertService();
            service.execute(request, response);
            System.out.println("8");
            view = "/board/board_list.board";
        } else if(uri.equals("/board/board_delete.board")) {
            service = new BoardDeleteService();
            service.execute(request, response);
            view = "/board/board_list.board";
        } else if(uri.equals("/board/board_update.board")) {
            service = new BoardUpdateService();
            service.execute(request, response);
            view = "/board/board_list.board";
        } else if(uri.equals("/board/board_list.board")) {
            service = new BoardListService();
            service.execute(request, response);
            view = "/board/board_list.jsp";
        } else if(uri.equals("/board/board_content.board")) {
            service = new BoardContentService();
            service.execute(request, response);
            view = "/board/board_content.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
