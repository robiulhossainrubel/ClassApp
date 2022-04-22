package com.rrinc.pustice.support;

public class Students {
    private String name,distname,phn,blood,nick,roll,email,bod,schl,clg;
    private int pic;

    public Students() {
    }

    public Students(String name, String distname, String phn, String blood, String nick, String roll, String email, String bod, String schl, String clg, int pic) {
        this.name = name;
        this.distname = distname;
        this.phn = phn;
        this.blood = blood;
        this.nick = nick;
        this.roll = roll;
        this.email = email;
        this.bod = bod;
        this.schl = schl;
        this.clg = clg;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistname() {
        return distname;
    }

    public void setDistname(String distname) {
        this.distname = distname;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getSchl() {
        return schl;
    }

    public void setSchl(String schl) {
        this.schl = schl;
    }

    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
