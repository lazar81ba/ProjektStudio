package com.studio.repository;

import com.studio.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    DataSource dataSource;


    private void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch  (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<Student> getAll() {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select s.id, s.name, s.surname, s.birth_date, s.sex," +
                "s.university_index,s.id_group from public.student s";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            List<Student> students = new LinkedList<>();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong(1));
                student.setName(resultSet.getString(2));
                student.setSurname(resultSet.getString(3));
                student.setBirthDate(resultSet.getDate(4));
                student.setSex(resultSet.getString(5));
                student.setUniversityIndex(resultSet.getString(6));
                student.setIdGroup(resultSet.getLong(7));
                students.add(student);
            }
            close(resultSet,preparedStatement,connection);
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
