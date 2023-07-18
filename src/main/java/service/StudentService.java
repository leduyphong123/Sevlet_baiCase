package service;

import entity.Student;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> getAll() throws SQLException, ClassNotFoundException;

    boolean create(String name, Date dateOfBirth, String address, String phoneNumber, String email, int cId) throws SQLException, ClassNotFoundException;

    Student getById(int id) throws SQLException, ClassNotFoundException;

    boolean edit(int id, String name, Date dateOfBirth, String address, String phoneNumber, String email, int cId) throws SQLException, ClassNotFoundException;

    void delete(int id) throws SQLException, ClassNotFoundException;

    List<Student> search(String name) throws SQLException, ClassNotFoundException;
}
