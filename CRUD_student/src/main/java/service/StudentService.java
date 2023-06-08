package service;

import dao.StudentDAO;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    StudentDAO studentDAO = new StudentDAO();
    public List<Student> findAll(){
        return studentDAO.findAll();
    }
    public Student findById(int id){
        return studentDAO.findById(id);
    }
    public void createStudent(Student student){
        studentDAO.insertStudent(student);
    }
    public void updateStudent(Student student){
        studentDAO.updateStudent(student);
    }
    public void deleteStudent(int id){
        studentDAO.deleteStudent(id);
    }
    public List<Student> searchStudent(String name){
        List<Student> result = new ArrayList<>();
        List<Student> students = findAll();
        for (Student student: students){
            if(student.getName().toUpperCase().contains(name.toUpperCase())){
                result.add(student);
            }
        }
        return result;
    }


}
