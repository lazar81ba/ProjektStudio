package com.studio.repository;

import com.studio.model.Group;
import com.studio.model.Specialization;
import com.studio.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class GroupRepository extends com.studio.repository.Repository{



    public Group getGroup(Long id) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select g.id, g.name, g.year, g.id_specialization, s.name from public.group g inner join public.specialization s on g.id_specialization=s.id where g.id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();
            Group group = new Group();
            if(resultSet.next()){
                group.setId(resultSet.getLong(1));
                group.setName(resultSet.getString(2));
                group.setYear(resultSet.getInt(3));
                Specialization specialization = new Specialization();
                specialization.setId(resultSet.getLong(4));
                specialization.setName(resultSet.getString(5));
                group.setSpecialization(specialization);
            }
            close(resultSet,preparedStatement,connection);
            return group;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
