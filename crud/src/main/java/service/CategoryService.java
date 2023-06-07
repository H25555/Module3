package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    static List<Category> categories;
    static{
        categories = new ArrayList<>();
        categories.add(new Category(1, "Foods"));
        categories.add(new Category(2,"Clothes"));
    }
    public List<Category> findAll(){
        return  categories;
    }
    public Category findById(int id){
        for (Category category: categories) {
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
