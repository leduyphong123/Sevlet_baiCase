package service.impl;

import entity.Student;
import repository.StudentRepository;
import service.StudentService;
import service.builder.StudentBuilder;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository repository = new StudentRepository();
    @Override
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }

    @Override
    public boolean create(String name, Date dateOfBirth, String address, String phoneNumber, String email, int cId) throws SQLException, ClassNotFoundException {
        if (name.length()>50 && address.length()>100 && phoneNumber.length()>10 && email.length()>50){
            return false;
        }
        Student student = new StudentBuilder()
                .withName(name)
                .withDateOfBirth(dateOfBirth)
                .withAddress(address)
                .withPhoneNumber(phoneNumber)
                .withEmail(email)
                .withClassRoomId(cId)
                .builder();

        return repository.create(student);
    }

    @Override
    public Student getById(int id) throws SQLException, ClassNotFoundException {
        for (Student element : getAll()){
            if (element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean edit(int id, String name, Date dateOfBirth, String address, String phoneNumber, String email, int cId) throws SQLException, ClassNotFoundException {
        if (name.length()>50 && address.length()>100 && phoneNumber.length()>10 && email.length()>50){
            return false;
        }
        Student student = new StudentBuilder()
                .withId(id)
                .withName(name)
                .withDateOfBirth(dateOfBirth)
                .withAddress(address)
                .withPhoneNumber(phoneNumber)
                .withEmail(email)
                .withClassRoomId(cId)
                .builder();

        return repository.edit(student);
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        repository.delete(id);
    }

    @Override
    public List<Student> search(String name) throws SQLException, ClassNotFoundException {
        return repository.search(name);
    }
}
