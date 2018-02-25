package com.accp.servlet;

import com.accp.biz.UserBiz;
import com.accp.biz.impl.UserBizImpl;
import com.accp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    UserBiz userImpl = new UserBizImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        if (method.equals("login")) {
            String userCode = req.getParameter("userCode");
            String userPassword = req.getParameter("userPassword");
            User user = userImpl.login(userCode, userPassword);
            if (user != null && user.getUserCode() != null) {
                req.getSession().setAttribute("User", user);
                req.getRequestDispatcher(req.getContextPath() + "jsp/frame.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "用户名或秘密错误！");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else if (method.equals("query")) {

        }
    }
}
