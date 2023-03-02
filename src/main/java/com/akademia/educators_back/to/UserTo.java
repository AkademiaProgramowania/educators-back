package com.akademia.educators_back.to;

public class UserTo {

    private long id;
    private String name;

    public UserTo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
