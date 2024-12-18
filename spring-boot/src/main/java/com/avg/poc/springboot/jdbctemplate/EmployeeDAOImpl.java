package com.avg.poc.springboot.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("JDBCTemplateEmployeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String TABLE = "EMPLOYEES";

    private static final String SQL_INSERT = "insert into " + TABLE + " (id, name, role) values (?,?,?)";
    private static final String SQL_BY_ID = "select name, role from " + TABLE + " where id = ?";
    private static final String SQL_UPDATE = "update " + TABLE + " set name=?, role=? where id=?";
    private static final String SQL_DELETE = "delete from " + TABLE + " where id=?";
    private static final String SQL_GET_ALL = "select id, name, role from " + TABLE;

    @Autowired
    @Qualifier("h2JDBCTemplateDataSource")
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Employee employee) {
        return jdbcTemplate.update(SQL_INSERT, employee.getId(), employee.getName(), employee.getRole()) > 0;
    }

    @Override
    public Employee getById(long id) {
        return jdbcTemplate.queryForObject(SQL_BY_ID, new Object[]{id}, new EmployeeMapper());
    }

    @Override
    public boolean update(Employee employee) {
        return jdbcTemplate.update(SQL_UPDATE, employee.getName(), employee.getRole(), employee.getId()) > 0L;

    }

    @Override
    public boolean deleteById(long id) {
        return jdbcTemplate.update(SQL_DELETE, id) > 0;
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
    }
}
