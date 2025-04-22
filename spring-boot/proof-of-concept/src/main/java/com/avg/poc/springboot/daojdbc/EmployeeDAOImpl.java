package com.avg.poc.springboot.daojdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("DaoJDBCEmployeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String TABLE = "EMPLOYEES";

    private static final String SQL_INSERT = "insert into " + TABLE + " (id, name, role) values (?,?,?)";
    private static final String SQL_BY_ID = "select name, role from " + TABLE + " where id = ?";
    private static final String SQL_UPDATE = "update " + TABLE + " set name=?, role=? where id=?";
    private static final String SQL_DELETE = "delete from " + TABLE + " where id=?";
    private static final String SQL_GET_ALL = "select id, name, role from " + TABLE;

    @Autowired
    @Qualifier("h2DataSource")
    DataSource dataSource;

    @Override
    public void save(Employee employee) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setLong(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getRole());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee saved with id=" + employee.getId());
            } else System.out.println("Employee save failed with id=" + employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(long id) {
        Employee emp = null;
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_BY_ID)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee();
                    emp.setId(id);
                    emp.setName(rs.getString("name"));
                    emp.setRole(rs.getString("role"));
                    System.out.println("Employee Found::" + emp);
                } else {
                    System.out.println("No Employee found with id=" + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public void update(Employee employee) {

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getRole());
            ps.setLong(3, employee.getId());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee updated with id=" + employee.getId());
            } else System.out.println("No Employee found with id=" + employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
            ps.setLong(1, id);
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee deleted with id=" + id);
            } else System.out.println("No Employee found with id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> empList = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_GET_ALL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setId(rs.getLong("id"));
                    emp.setName(rs.getString("name"));
                    emp.setRole(rs.getString("role"));
                    empList.add(emp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }
}
