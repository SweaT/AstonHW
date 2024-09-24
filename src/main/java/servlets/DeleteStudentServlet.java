package servlets;

import DAO.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentDelete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("studentID").isEmpty() ){
            resp.getWriter().write("Please enter student's ID\n");
        }
        int studentID = Integer.parseInt(req.getParameter("studentID"));

        boolean isStudentDeleted = StudentDAO.getInstance().deleteByID(studentID);
        if (isStudentDeleted){
            resp.getWriter().write("Student has been successfully deleted");
        }
        else {
            resp.getWriter().write("There's no such student\n");
        }
    }
}
