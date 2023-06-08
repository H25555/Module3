package Controller;

import model.Gender;
import model.Student;
import model.StudentClass;
import service.GenderService;
import service.StudentClassService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "studentServlet",urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    StudentClassService classService = new StudentClassService();
    GenderService genderService = new GenderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateStudent(req,resp);
                break;
            case "update":
                showUpdate(req,resp);
                break;
            case "delete":
                deleteStudent(req,resp);
            default:
                showStudent(req,resp);
        }
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Student student = studentService.findById(id);
        req.setAttribute("student", student);
        req.setAttribute("genders", genderService.findAll());
        req.setAttribute("studentClasses", classService.findAll());
        req.getRequestDispatcher("update.jsp")
                .forward(req, resp);
    }

    private void showCreateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genders",genderService.findAll());
        req.setAttribute("studentClasses",classService.findAll());
        req.getRequestDispatcher("create.jsp").forward(req,resp);
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date dob = Date.valueOf(req.getParameter("dob"));
        int genderId = Integer.parseInt(req.getParameter("gender"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Gender gender = genderService.findById(genderId);
        StudentClass studentClass = classService.findById(classId);
        Student student = new Student(name,dob,gender,studentClass);
        studentService.createStudent(student);
        req.setAttribute("student" ,student);
        req.setAttribute("message", "CREATED");
        req.setAttribute("genders",genderService.findAll());
        req.setAttribute("studentClasses", classService.findAll());
        req.getRequestDispatcher("create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(req,resp);
                break;
            case "update":
                updateStudent(req,resp);
                break;
            default:
                showStudent(req,resp);
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);
        showStudent(req,resp);
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Date dob = Date.valueOf(req.getParameter("dob"));
        int genderId = Integer.parseInt(req.getParameter("gender"));
        int classId = Integer.parseInt(req.getParameter("studentClass"));
        Gender gender = genderService.findById(genderId);
        StudentClass studentClass = classService.findById(classId);
        Student student = new Student(id,name,dob,gender,studentClass);
        studentService.updateStudent(student);
//        req.setAttribute("student" ,student);
        req.setAttribute("message", "CREATED");
        req.setAttribute("genders",genderService.findAll());
        req.setAttribute("classes", classService.findAll());
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }

    private void showStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
                 // orderBy: name, age, address


        if(search == null){
            search = "";
        }

//        List<Student>  list = studentService.searchStudent(search);
        List<Student>  list = studentService.searchStudent(search);
        req.setAttribute("students",list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
