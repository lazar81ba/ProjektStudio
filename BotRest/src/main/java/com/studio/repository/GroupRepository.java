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



    public Group getGroupById(Long id) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select  g.name, g.year, s.name from public.group g inner join public.specialization s on g.id_specialization=s.id where g.id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();
            Group group = new Group();
            if(resultSet.next()){
                group.setName(resultSet.getString(1));
                group.setYear(resultSet.getInt(2));
                Specialization specialization = new Specialization();
                specialization.setName(resultSet.getString(3));
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
