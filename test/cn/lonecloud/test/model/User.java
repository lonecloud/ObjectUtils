package cn.lonecloud.test.model;

import java.util.Date;

/**
 * Created by lonecloud on 17/3/12.
 */
public class User {
    int id;
    String name;
    int year;
    Date date;
    Role role;


    public User(int id, String name, int year, Date date) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.date=date;

    }

    public User(int id, String name, int year, Date date, Role role) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.date = date;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
