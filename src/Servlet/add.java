package Servlet;

import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/add")
public class add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String score = req.getParameter("score");
        Student student = new Student(name, Integer.parseInt(age), gender, Integer.parseInt(score));
        BufferedWriter bfw = new BufferedWriter(new FileWriter("D:\\Student.txt",true));
        bfw.write(student.toString());
        bfw.newLine();
        bfw.close();
        resp.getWriter().write("保存成功！3秒后自动跳转到首页...");
        resp.setHeader("Refresh","3,URL=/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
