package com.studio.service.implementation;

import com.studio.model.Plan;
import com.studio.repository.ScheduleDAO;
import com.studio.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class ScheduleServiceImpl implements ScheduleService {


    @Autowired
    ScheduleDAO scheduleDAO;

    @Override
    public Plan getPlanForStudent(String index)
    {
        return new Plan(scheduleDAO.findByStudentIndex(index));
    }

    @Override
    public Plan getPlanForStudentByDay(String index, Date date) {
        return new Plan(scheduleDAO.findByStudentIndexAndDate(index,date,getNextDayDate(date))); }

    @Override
    public Plan getPlanForStudentByWeek(String index, Date date) {
        return new Plan(scheduleDAO.findByStudentIndexAndDate(index,getFirstDayOfWeekDate(date)
                ,getFirstDayOfNextWeekDate(date)));
    }

    @Override
    public Plan getPlanForEmployee(String universityNick) {
        return new Plan(scheduleDAO.findByEmployeeNick(universityNick));
    }

    @Override
    public Plan getPlanForEmployeeByDay(String universityNick, Date date) {
        return new Plan(scheduleDAO.findByEmployeeNickAndDate(universityNick,date,getNextDayDate(date))); }

    @Override
    public Plan getPlanForEmployeeByWeek(String universityNick, Date date) {
        return new Plan(scheduleDAO.findByEmployeeNickAndDate(universityNick,getFirstDayOfWeekDate(date)
                ,getFirstDayOfNextWeekDate(date)));
    }

    //TODO tests
    private Date getNextDayDate(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
    private Date getFirstDayOfNextWeekDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        resetCalendar(cal);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        return cal.getTime();
    }

    private Date getFirstDayOfWeekDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        resetCalendar(cal);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return cal.getTime();
    }

    private void resetCalendar(Calendar cal){
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
    }

}
