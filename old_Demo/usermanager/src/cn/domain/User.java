package cn.domain;

import org.springframework.cglib.core.TinyBitSet;

import java.sql.Time;

public class User {
    private int travellerid;
    private String name;
    private String gender;
    private String wp;
    private String time;
    private String start;
    private String end;
    private String level;
    private String username;
    private String password;

    public int getTravellerid() {
        return travellerid;
    }

    public void setTravellerid(int travellerid) {
        this.travellerid = travellerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "travellerid=" + travellerid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", wp=" + wp +
                ", time='" + time + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
