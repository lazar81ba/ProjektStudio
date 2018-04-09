package com.studio.repository;

import com.studio.model.Specialization;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class SpecializationRepository extends com.studio.repository.Repository {

    public Specialization getSpecialization(Long id) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select s.id, s.name from public.specialization s where s.id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();
            Specialization specialization = new Specialization();
            if(resultSet.next()){
                specialization.setId(resultSet.getLong(1));
                specialization.setName(resultSet.getString(2));
            }
            close(resultSet,preparedStatement,connection);
            return specialization;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
