package repository;

import entity.ClassRoom;
import entity.Student;
import service.builder.ClassRoomBuilder;
import service.builder.StudentBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constant.Query.R_CLASSROOM;


public class ClassRoomRepository {
    public List<ClassRoom> getAll() throws SQLException, ClassNotFoundException {
        List<ClassRoom> classRoomList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(R_CLASSROOM);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                ClassRoom ClassRoom = new ClassRoomBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .builder();
                classRoomList.add(ClassRoom);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return classRoomList;
    }
}
