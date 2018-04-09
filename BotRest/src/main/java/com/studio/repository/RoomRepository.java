package com.studio.repository;

import com.studio.model.Room;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class RoomRepository extends com.studio.repository.Repository{

    public Room getRoomById(Long id) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select r.name,r.building, r.level from public.room r where r.id=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();
            Room room = new Room();
            if(resultSet.next()){
                room.setName(resultSet.getString(1));
                room.setBuilding(resultSet.getString(2));
                room.setLevel(resultSet.getInt(3));
            }
            close(resultSet,preparedStatement,connection);
            return room;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
