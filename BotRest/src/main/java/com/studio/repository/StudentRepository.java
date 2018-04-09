package com.studio.repository;

import com.studio.model.Student;
import com.studio.service.GroupService;
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
public class StudentRepository extends com.studio.repository.Repository {

    @Autowired
    GroupService groupService;

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
                student.setGroup(groupService.getGroup(resultSet.getLong(7)));
                students.add(student);
            }
            close(resultSet,preparedStatement,connection);
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public Student getStudent(String index) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select s.id, s.name, s.surname, s.birth_date, s.sex," +
                "s.id_group from public.student s where s.university_index= ? ";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,index);

            resultSet = preparedStatement.executeQuery();
            Student student = new Student();
            if(resultSet.next()){
                student.setId(resultSet.getLong(1));
                student.setName(resultSet.getString(2));
                student.setSurname(resultSet.getString(3));
                student.setBirthDate(resultSet.getDate(4));
                student.setSex(resultSet.getString(5));
                student.setUniversityIndex(index);
                student.setGroup(groupService.getGroup(resultSet.getLong(6)));
            }
            close(resultSet,preparedStatement,connection);
            return student;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
