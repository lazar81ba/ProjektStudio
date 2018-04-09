package com.studio.repository;

import com.studio.model.Schedule;
import com.studio.model.SchedulePosition;
import com.studio.service.GroupService;
import com.studio.service.RoomService;
import com.studio.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.*;
import java.text.SimpleDateFormat;

@Repository
@Transactional
public class ScheduleRepository extends com.studio.repository.Repository{

    @Autowired
    SubjectService subjectService;

    @Autowired
    RoomService roomService;

    @Autowired
    GroupService groupService;

    public Schedule getScheduleByIndex(String index) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select sch.id_subject, sch.id_group, sch.id_room, sch.data_start, sch.data_end from public.student s inner join public.group g on g.id=s.id_group INNER JOIN public.schedule sch on sch.id_group=g.id where s.university_index=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,index);

            resultSet = preparedStatement.executeQuery();
            Schedule schedule = getScheduleFromResultSet(resultSet);
            close(resultSet,preparedStatement,connection);
            return schedule;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    private Schedule getScheduleFromResultSet(ResultSet resultSet) throws SQLException {
        Schedule schedule = new Schedule();
        while(resultSet.next()){
            SchedulePosition position = new SchedulePosition();
            position.setSubject(subjectService.getSubject(resultSet.getLong(1)));
            position.setGroup(groupService.getGroup(resultSet.getLong(2)));
            position.setRoom(roomService.getRoom(resultSet.getLong(3)));
            position.setDateStart(resultSet.getTimestamp(4).toString());
            position.setDateEnd(resultSet.getTimestamp(5).toString());
            schedule.addSchedulePosition(position);
        }
        return schedule;
    }

    private String extractFromTimestamp(String type, Timestamp date){
        return new SimpleDateFormat(type).format(new Date(date.getTime()));
    }

    public Schedule getScheduleByIndexAndDay(String index, Timestamp date) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "select sch.id_subject, sch.id_group, sch.id_room, sch.data_start, sch.data_end from public.student s inner join public.group g on g.id=s.id_group INNER JOIN public.schedule sch on sch.id_group=g.id " +
                "where s.university_index=? and date_part('year',sch.data_end)=? and date_part('month',sch.data_end)=? and date_part('day',sch.data_end)=?";
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,index);
            preparedStatement.setInt(2,Integer.parseInt(extractFromTimestamp("yyyy",date)));
            preparedStatement.setInt(3,Integer.parseInt(extractFromTimestamp("MM",date)));
            preparedStatement.setInt(4,Integer.parseInt(extractFromTimestamp("dd",date)));

            resultSet = preparedStatement.executeQuery();
            Schedule schedule = getScheduleFromResultSet(resultSet);
            close(resultSet,preparedStatement,connection);
            return schedule;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;


    }

}
