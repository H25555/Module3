package service;

import dao.ClassDAO;
import model.StudentClass;

import java.util.List;

public class StudentClassService {
    ClassDAO classDAO = new ClassDAO();
    public List<StudentClass> findAll(){
        return classDAO.findAll();
    }
    public StudentClass findById(int id){
        return classDAO.findById(id);
    }
}
