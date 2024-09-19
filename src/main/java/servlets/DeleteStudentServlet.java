package servlets;

import DAO.StudentDAO;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/studentDelete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("studentID").isEmpty() ){
            resp.getWriter().write("Please enter student's ID\n");
        }
        int studentID = Integer.parseInt(req.getParameter("studentID"));

        try {
           boolean isStudentDeleted = StudentDAO.getInstance().delete(studentID);
            if (isStudentDeleted){
                resp.getWriter().write("Student has been successfully deleted");
            }
            else {
                resp.getWriter().write("There's no such student\n");
            }

        } catch (SQLException e) {
            resp.getWriter().write("Student not deleted cause of exception: " + e.getMessage());;
        }
    }
}
