package repository;

import entity.Student;
import service.builder.StudentBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constant.Query.*;

public class StudentRepository {

    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(R_STUDENT);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Student student = new StudentBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"))
                        .withAddress(resultSet.getString("ADDRESS"))
                        .withPhoneNumber(resultSet.getString("PHONE_NUMBER"))
                        .withEmail(resultSet.getString("EMAIL"))
                        .withClassRoomId(resultSet.getInt("C_ID"))
                        .builder();
                studentList.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return studentList;
    }

    public boolean create(Student student) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(C_STUDENT);
            pstm.setString(1,student.getName());
            pstm.setDate(2,student.getDateOfBirth());
            pstm.setString(3,student.getAddress());
            pstm.setString(4,student.getPhoneNumber());
            pstm.setString(5,student.getEmail());
            pstm.setInt(6,student.getcId());
            pstm.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            pstm.close();
            conn.close();
        }
    }

    public boolean edit(Student student) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(U_STUDENT);
            pstm.setString(1,student.getName());
            pstm.setDate(2,student.getDateOfBirth());
            pstm.setString(3,student.getAddress());
            pstm.setString(4,student.getPhoneNumber());
            pstm.setString(5,student.getEmail());
            pstm.setInt(6,student.getcId());
            pstm.setInt(7,student.getId());
            pstm.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            pstm.close();
            conn.close();
        }
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(D_STUDENT);
            pstm.setInt(1,id);
            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
    }

    public List<Student> search(String name) throws SQLException, ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(R_NAME_STUDENT);
            pstm.setString(1,"%"+name+"%");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Student student = new StudentBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"))
                        .withAddress(resultSet.getString("ADDRESS"))
                        .withPhoneNumber(resultSet.getString("PHONE_NUMBER"))
                        .withEmail(resultSet.getString("EMAIL"))
                        .withClassRoomId(resultSet.getInt("C_ID"))
                        .builder();
                studentList.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return studentList;
    }
}
