package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/students")
public class GetAllStudentsServlet extends HttpServlet {
    private final StudentService studentService = StudentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try (var writer = resp.getWriter()) {
            writer.write("<h1>Список студентов</h1>");
            writer.write("<ul>");
            studentService.findall().stream().forEach(studentDTO ->
                    writer.write("""
                            <li> 
                            <a href='/students?studentId=%d'>%s</a>
                            </li>  
                            """.formatted(studentDTO.id(), studentDTO.description())));
            writer.write("</ul>");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
