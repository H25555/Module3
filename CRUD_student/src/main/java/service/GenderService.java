package service;

import dao.GenderDAO;
import model.Gender;

import java.util.List;

public class GenderService {
    GenderDAO genderDAO = new GenderDAO();
    public List<Gender> findAll(){
        return genderDAO.findAll();
    }
    public Gender findById(int id){
        return genderDAO.findById(id);
    }
}
