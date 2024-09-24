package servlets;

import DAO.SchoolClassDAO;
import DAO.StudentDAO;
import entity.SchoolClass;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/studentUpdate")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("name");
        String newClassID = req.getParameter("classID");

        if (req.getParameter("studentID").isEmpty()) {
            resp.getWriter().write("Please enter the student's ID\n");
        }

        Student student = StudentDAO.getInstance().getById(Integer.parseInt(req.getParameter("studentID")));

        if (!newName.isEmpty()) {
            student.setName(newName);
        }
        if (!newClassID.isEmpty()) {
            student.setSchoolClass(
                    SchoolClassDAO.getInstance().get(Integer.parseInt(newClassID)));
        }

        boolean isStudentUpdated = StudentDAO.getInstance().update(student);

        if (isStudentUpdated) {
            resp.getWriter().write("Student Updated Successfully");
        } else {
            resp.getWriter().write("Student Not Updated");
        }
    }
}
