package service.builder;

import entity.ClassRoom;

public class ClassRoomBuilder {
    private int id;
    private String name;
    public ClassRoomBuilder withId(int id){
        this.id = id;
        return this;
    }
    public ClassRoomBuilder withName(String name){
        this.name = name;
        return this;
    }
    public ClassRoom builder(){
        return new ClassRoom(id,name);
    }

}
