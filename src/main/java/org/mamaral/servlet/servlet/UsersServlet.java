package org.mamaral.servlet.servlet;

import org.mamaral.service.UsersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
@WebServlet("/")
public class UsersServlet extends HttpServlet {
    static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @Inject
    UsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);
        writer.println("<h1>" + usersService.createHelloMessage("World") + "</h1>");
        writer.println(PAGE_FOOTER);
        writer.close();
    }
}
