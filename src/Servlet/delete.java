package Servlet;

import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/delete")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        BufferedReader bfr = new BufferedReader(new FileReader("D:\\Student.txt"));
        ArrayList<Student> students = new ArrayList<>();
        String line;
        while ((line = bfr.readLine()) != null) {
            String[] arr = line.split(",");
            Student student = new Student(arr[0], Integer.parseInt(arr[1]), arr[2], Integer.parseInt(arr[3]));
            students.add(student);
        }
        bfr.close();
        for (Student student : students) {
            if (student.getName().equals(name)){
                students.remove(student);
                break;
            }
            else {
                resp.getWriter().write("删除失败，您输入的姓名不存在！三秒后自动跳转的首页...");
                resp.setHeader("Refresh","3,URL=/main.jsp");
                return;
            }
        }
        BufferedWriter bfw=new BufferedWriter(new FileWriter("D:\\Student.txt"));
        for (Student student : students) {
            bfw.write(student.toString());
            bfw.newLine();
            bfw.flush();
        }
        bfw.close();
        resp.getWriter().write("删除成功！三秒后自动跳转到首页...");
        resp.setHeader("Refresh","3,URL=/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
