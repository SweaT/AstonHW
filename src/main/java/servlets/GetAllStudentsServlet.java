package servlets;

import DAO.StudentDAO;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class GetAllStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = StudentDAO.getInstance().getAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/students.jsp").forward(req, resp);
    }
}
