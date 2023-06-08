package dao;

import model.Gender;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class GenderDAO extends ConnectionDatabase{
    private final String SELECT_GENDER = "SELECT * FROM gender";
    private final String SELECT_GENDER_BY_ID = "SELECT * FROM gender WHERE id = ?";
    public List<Gender> findAll(){
        List<Gender> genders = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_GENDER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("gender");
                genders.add(new Gender(id, name));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return genders;
    }
    public Gender findById(int id) {
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_GENDER_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                int idCus = rs.getInt("id");
                String name = rs.getString("gender");

                return new Gender(idCus, name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
