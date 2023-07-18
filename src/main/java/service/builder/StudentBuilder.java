package service.builder;

import entity.Student;

import java.sql.Date;
import java.sql.Timestamp;

public class StudentBuilder {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private int cId;
    public StudentBuilder withId(int id){
        this.id = id;
        return this;
    }
    public StudentBuilder withName(String name){
        this.name = name;
        return this;
    }
    public StudentBuilder withDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public StudentBuilder withAddress(String address){
        this.address = address;
        return this;
    }
    public StudentBuilder withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }
    public StudentBuilder withEmail(String email){
        this.email = email;
        return this;
    }
    public StudentBuilder withClassRoomId(int cId){
        this.cId = cId;
        return this;
    }
    public Student builder(){
        return new Student(id,name,dateOfBirth,address,phoneNumber,email,cId);
    }
}
