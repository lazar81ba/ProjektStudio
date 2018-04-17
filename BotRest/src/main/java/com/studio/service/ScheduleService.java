package com.studio.service;

import com.studio.model.Plan;

import java.util.Date;

public interface ScheduleService {
    public Plan getPlanForStudent(String index);
    public Plan getPlanForStudentByDay(String index, Date date);
    public Plan getPlanForStudentByWeek(String index, Date date);
    public Plan getPlanForEmployee(String universityNick);
    public Plan getPlanForEmployeeByDay(String universityNick, Date date);
    public Plan getPlanForEmployeeByWeek(String universityNick, Date date);
}
