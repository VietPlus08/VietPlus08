package com.java.entities;

public class Student {
    String id;
    String name, className;

    public Student(String id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
