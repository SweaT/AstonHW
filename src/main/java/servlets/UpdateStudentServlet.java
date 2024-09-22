//package servlets;
//
//import DAO.StudentDAO;
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
//@WebServlet("/studentUpdate")
//public class UpdateStudentServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Student student;
//        String newName = req.getParameter("name");
//        String newClassID = req.getParameter("classID");
//
//        if (req.getParameter("studentID").isEmpty()) {
//            resp.getWriter().write("Please enter the student's ID\n");
//        }
//
//        try {
//             student = StudentDAO.getInstance().getById(Integer.parseInt(req.getParameter("studentID")));
//        } catch (SQLException e) {
//            resp.getWriter().write("Can't find such Student due to exception: " + e.getMessage());
//            return;
//        }
//
//        if (!newName.isEmpty()) {
//            student.setName(newName);
//        }
//        if (!newClassID.isEmpty()) {
//            student.setClassID(Integer.parseInt(newClassID));
//        }
//
//        boolean isStudentUpdated;
//        try {
//            isStudentUpdated = StudentDAO.getInstance().update(student);
//        } catch (SQLException e) {
//            resp.getWriter().write("Can't update student due to exception: " + e.getMessage());
//            return;
//        }
//
//        if (isStudentUpdated) {
//            resp.getWriter().write("Student Updated Successfully\n");
//        } else {
//            resp.getWriter().write("Student Not Updated\n");
//        }
//    }
//}
