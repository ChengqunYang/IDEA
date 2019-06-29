package cn.domain;

import java.sql.Time;

public class order {
    private int orderid;
    private int ticketid;
    private int travellerid;
    private String name;
    private String ordertime;
    private String state;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

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

    public String  getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderid=" + orderid +
                ", ticketid=" + ticketid +
                ", travellerid=" + travellerid +
                ", name='" + name + '\'' +
                ", ordertime=" + ordertime +
                ", state='" + state + '\'' +
                '}';
    }
}
