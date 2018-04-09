package com.studio.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Repository {
    @Autowired
    DataSource dataSource;

    protected void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch  (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
