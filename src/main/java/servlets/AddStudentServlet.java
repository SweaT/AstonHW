//package servlets;
//
////import DAO.StudentDAO;
//import entity.Student;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet("/studentAdd")
//public class AddStudentServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/studentManipulation.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getParameter("name").isEmpty() || req.getParameter("classID").isEmpty()) {
//            resp.getWriter().write("Please enter the name and class ID\n");
//
//        }
//        String name = req.getParameter("name");
//        int schoolClass = Integer.parseInt(req.getParameter("classID"));
//
//        //easterEgg
//        if (name.equals("Cat")) {
//            resp.sendRedirect("easterEgg.jsp");
//            return;
//        }
//
//        try {
//            Student newStudent = StudentDAO.getInstance().create(new Student(name, schoolClass));
//            req.setAttribute("student", newStudent);
//            resp.getWriter().write("Student added, student's id = " + newStudent.getId());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
