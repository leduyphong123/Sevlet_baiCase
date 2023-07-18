package service.impl;

import entity.ClassRoom;
import repository.ClassRoomRepository;
import service.ClassRoomService;

import java.sql.SQLException;
import java.util.List;

public class ClassRoomServiceImpl implements ClassRoomService {
    private ClassRoomRepository repository = new ClassRoomRepository();
    @Override
    public List<ClassRoom> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }
}
