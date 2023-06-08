package dao;
import model.StudentClass;
import model.Gender;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO extends ConnectionDatabase{
    private final String SELECT_STUDENTS = "SELECT st.*, gd.gender, class.name as class FROM students st left join gender gd on st.id_gender = gd.id left join class on st.id_class = class.id;";
    private final String SELECT_STUDENTS_BY_ID = "SELECT st.*, gd.gender, class.name as class FROM students st left join gender gd on st.id_gender = gd.id left join class on st.id_class = class.id where st.id = ?;";
    private final String INSERT_STUDENTS = "INSERT INTO `student_crud`.`students` (`name`, `dob`, `id_gender`, `id_class`) VALUES (?, ?, ?, ?);";
    private final String UPDATE_STUDENTS = "UPDATE `student_crud`.`students` SET `name` = ?, `dob` = ?, `id_gender` = ?, `id_class` = ? WHERE (`id` = ?);";
    private final String DELETE_STUDENTS = "DELETE FROM `student_crud`.`students` WHERE (`id` = ?);";
    private final String SORT_STUDENTS_ASC = "SELECT * FROM student_crud.students order by name ASC;";
    public List<Student> findAll() {
        List<Student> customers = new ArrayList<>();
        // Step 1: tạo 1 kết nối xuống db để gọi câu lệnh SELECT or UPDATE, Delete, vv
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_STUDENTS);) {
            System.out.println(preparedStatement);
            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                //(truyên vào tên cột)
                int id = rs.getInt("id");
                //(truyên vào tên cột)
                String name = rs.getString("name");
                //(truyên vào tên cột)
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                int genderId = rs.getInt("id_gender");
                String studentClass = rs.getString("class");
                int classId = rs.getInt("id_class");
                customers.add(new Student(id, name, dob, new Gender(genderId,gender), new StudentClass(classId,studentClass)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }
    public Student findById(int id) {
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_STUDENTS_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                //(truyên vào tên cột)
                int idCus = rs.getInt("id");
                //(truyên vào tên cột)
                String name = rs.getString("name");
                //(truyên vào tên cột)
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                int genderId = rs.getInt("id_gender");
                String studentClass = rs.getString("class");
                int classId = rs.getInt("id_class");
                return new Student(idCus, name, dob, new Gender(genderId,gender), new StudentClass(classId,studentClass));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void insertStudent(Student student) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getDob());
            preparedStatement.setInt(3, student.getGender().getId());
            preparedStatement.setInt(4, student.getStudentClass().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateStudent(Student student) {

        try (Connection connection = getConnection();
             //UPDATE `customers` " +
             //            "SET `name` = ?, `email` = ?, role_id = ? WHERE (`id` = ?);";
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getDob());
            preparedStatement.setInt(3, student.getGender().getId());
            preparedStatement.setInt(4, student.getStudentClass().getId());
            preparedStatement.setInt(5, student.getId());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteStudent(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Student> sortASC(){
        List<Student> customers = new ArrayList<>();
        // Step 1: tạo 1 kết nối xuống db để gọi câu lệnh SELECT or UPDATE, Delete, vv
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SORT_STUDENTS_ASC);) {
            System.out.println(preparedStatement);
            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                //(truyên vào tên cột)
                int id = rs.getInt("id");
                //(truyên vào tên cột)
                String name = rs.getString("name");
                //(truyên vào tên cột)
                Date dob = rs.getDate("dob");
                String gender = rs.getString("gender");
                int genderId = rs.getInt("id_gender");
                String studentClass = rs.getString("class");
                int classId = rs.getInt("id_class");
                customers.add(new Student(id, name, dob, new Gender(genderId,gender), new StudentClass(classId,studentClass)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }
}
