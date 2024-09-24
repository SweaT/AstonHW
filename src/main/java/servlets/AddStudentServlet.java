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


@WebServlet("/studentAdd")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/studentManipulation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name").isEmpty() || req.getParameter("classID").isEmpty()) {
            resp.getWriter().write("Please enter the student's name and class ID");
        }

        String name = req.getParameter("name");
        int schoolClassID = Integer.parseInt(req.getParameter("classID"));

        //easterEgg
        if (name.equals("Cat")) {
            resp.sendRedirect("easterEgg.jsp");
            return;
        }

        SchoolClass schoolClassObj = SchoolClassDAO.getInstance().get(schoolClassID);
        Student newStudent = Student.builder().name(name).schoolClass(schoolClassObj).build();
        newStudent = StudentDAO.getInstance().create(newStudent);

        resp.getWriter().write("Student added, student's id = " + newStudent.getId());

    }
}
