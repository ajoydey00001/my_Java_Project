package util;

import java.io.Serializable;

public class Player implements Serializable {
    private String name , country,position,club;
    private int age,number;
    private double height, weeklysalary,sellrate;
    public Player()
    {

    }
    public Player(String s, String c, int a, double h, String n, String p, int num, double w,double sell){
        name=s;
        country=c;
        age=a;
        height=h;
        club=n;
        position=p;
        number=num;
        weeklysalary=w;
        sellrate = sell;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setWeeklysalary(double weeklysalary) {
        this.weeklysalary = weeklysalary;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeeklysalary() {
        return weeklysalary;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public String getClub() {
        return club;
    }

    public String getCountry() {
        return country;
    }

    public String getPosition() {
        return position;
    }
    public void setSellrate(double s) {
        this.sellrate = s;
    }
    public double getSellrate(){
        return sellrate;
    }
}

