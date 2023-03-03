package fr.aelion.repositories;

import fr.aelion.dbal.DbConnect;
import fr.aelion.dbal.postgres.PgConnect;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends Repository<Student>{
    private List<Student> students = new ArrayList<>();
    private DbConnect dbConnect;



    public StudentRepository (Class<Student> className) throws SQLException {
        super(className);
        this.dbConnect = PgConnect.getInstance();
    }
    public List<Student> findAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        String sqlQuerry = getSelectQuery().substring(0,getSelectQuery().length()-1)+" order by last_name, first_name";

        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuerry);
        while (resultSet.next()) {
            Student student = new Student();

            student.setEmail(resultSet.getString("email"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            students.add(student);
        }

        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        return students;
    }
    public Student find(int id) throws SQLException, StudentException {
        Connection connection = dbConnect.connect();
        // Need a SQL Query
        String sqlQuerry = getSelectQuery();

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuerry);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Student student = new Student();

            student.setEmail(resultSet.getString("email"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            preparedStatement.close();
            resultSet.close();
            this.dbConnect.disconnect();

            return student;
        }
        preparedStatement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        throw StudentException.studentNotFoundException();

    }
    public Student findByLoginAndPassword(String login, String password) throws SQLException {
// implement+test apres manger

        Student student = new Student();
        String sqlQuerry = getSelectQuery().substring(0,getSelectQuery().length()-1)+" where login='" + login + "' and password ='" + password+"'";

        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuerry);
        resultSet.next();
        student.setId(resultSet.getInt("id"));
        student.setLastName(resultSet.getString("last_name"));
        student.setFirstName(resultSet.getString("first_name"));
        student.setEmail(resultSet.getString("email"));
        student.setPhoneNumber(resultSet.getString("phone_number"));
        student.setLogin(resultSet.getString("login"));
        student.setPassword(resultSet.getString("password"));


        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        return student;
    }



}
