package com.studio.repository;

import com.studio.model.Specialization;
import com.studio.model.Subject;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class SubjectRepository extends com.studio.repository.Repository{

    public Subject getSubjectById(Long id) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select s.name,s.description from public.subject s where s.id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();
            Subject subject = new Subject();
            if(resultSet.next()){
                subject.setName(resultSet.getString(1));
                subject.setDescription(resultSet.getString(2));
            }
            close(resultSet,preparedStatement,connection);
            return subject;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
