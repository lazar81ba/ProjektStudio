package com.studio.repository;

import com.studio.model.Consultation;
import com.studio.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class EmployeeRepository extends com.studio.repository.Repository{

    @Autowired
    RoomService roomService;


    public Consultation getConsultationByName(String name, String surname){
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select  e.start_consultation_time, e.end_consultation_time, e.consultation_day,e.id_room from public.employee e where e.name=? and e.surname=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);

            resultSet = preparedStatement.executeQuery();
            Consultation consultation = new Consultation();
            if(resultSet.next()){
                consultation.setStartConsultationTime(resultSet.getTime(1));
                consultation.setEndConsultationTime(resultSet.getTime(2));
                consultation.setConsultationDay(resultSet.getString(3));
                consultation.setRoom(roomService.getRoom(resultSet.getLong(4)));
            }
            close(resultSet,preparedStatement,connection);
            return consultation;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
