package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/studentAdd")
public class AddStudentServlet extends HttpServlet {

    private final StudentService studentService = StudentService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try (var writer = resp.getWriter()) {
            writer.write("<h1>Добавьте студента</h1>");
            writer.write("<label for=\"name\">Student name:</label>\n" +
                    "\n" +
                    "<input type=\"text\" id=\"name\" name=\"name\" required minlength=\"4\" maxlength=\"15\" size=\"10\" />");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
