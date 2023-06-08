package dao;

import model.Gender;
import model.StudentClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends ConnectionDatabase{
    private final String SELECT_CLASS = "SELECT * FROM class";
    private final String SELECT_CLASS_BY_ID = "SELECT * FROM class WHERE id = ?";
    public List<StudentClass> findAll(){
        List<StudentClass> genders = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_CLASS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                genders.add(new StudentClass(id, name));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return genders;
    }
    public StudentClass findById(int id) {
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_CLASS_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                int idCus = rs.getInt("id");
                String name = rs.getString("name");

                return new StudentClass(idCus, name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
