package com.studio.repository;

import com.studio.model.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ScheduleDAO extends CrudRepository<Schedule,Long> {

    @Query("select sch from Schedule sch, Student s inner join sch.group g where s.group=g and s.index=?1")
    public List<Schedule> findByStudentIndex(String index);

    @Query("select sch from Schedule sch, Student s inner join sch.group g where s.group=g and s.index=?1 " +
            "and sch.dateStart>=?2 and sch.dateEnd<=?3")
    public List<Schedule> findByStudentIndexAndDate(String index,Date date,Date date2);

    @Query("select sch from Schedule sch, Employee e inner join sch.subject su where su in elements(e.subjects) and e.universityNick=?1  ")
    public List<Schedule> findByEmployeeNick(String employeeNick);

    @Query("select sch from Schedule sch, Employee e inner join sch.subject su where su in elements(e.subjects) and e.universityNick=?1  " +
            "and sch.dateStart>=?2 and sch.dateEnd<=?3")
    public List<Schedule> findByEmployeeNickAndDate(String employeeNick,Date date,Date date2);
}
