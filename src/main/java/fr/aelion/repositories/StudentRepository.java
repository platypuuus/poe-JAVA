package fr.aelion.repositories;

import fr.aelion.dbal.DbConnect;
import fr.aelion.dbal.postgres.PgConnect;
import fr.aelion.helpers.builders.students.StudentBuilder;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();
    private DbConnect dbConnect;

    public StudentRepository() throws StudentException {
        this.dbConnect = PgConnect.getInstance();
    }

    public List<Student> findAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        String sqlQuerry = "select id, last_name,first_name,email,phone_number,login,password ";
        sqlQuerry += "from student order by last_name, first_name";

        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuerry);
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt(1));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setUsername(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            students.add(student);
        }

        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        return students;
    }

    public Student findByLoginAndPassword(String login, String password) throws SQLException {
// implement+test apres manger

        Student student = new Student();
        String sqlQuerry = "select id, last_name,first_name,email,phone_number,login,password from student where login='" + login + "' and password ='" + password+"'";

        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuerry);
        resultSet.next();
        student.setId(resultSet.getInt(1));
        student.setLastName(resultSet.getString("last_name"));
        student.setFirstName(resultSet.getString("first_name"));
        student.setEmail(resultSet.getString("email"));
        student.setPhoneNumber(resultSet.getString("phone_number"));
        student.setUsername(resultSet.getString("login"));
        student.setPassword(resultSet.getString("password"));


        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        return student;
    }


}
