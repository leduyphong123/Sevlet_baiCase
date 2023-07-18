package service;

import entity.ClassRoom;

import java.sql.SQLException;
import java.util.List;

public interface ClassRoomService {
    List<ClassRoom> getAll() throws SQLException, ClassNotFoundException;
}
