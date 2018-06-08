package controller;

import model.Student;
import repository.StudentRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {

    @EJB
    private StudentRepository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = repository.findAll();
        req.setAttribute("list", list);

        req.getRequestDispatcher("/").forward(req, resp);
    }
}
