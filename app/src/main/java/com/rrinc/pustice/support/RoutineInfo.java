package com.rrinc.pustice.support;

public class RoutineInfo {

    private String clsTitl, clsCode, clsTime,clsTech,clsRoom;

    public RoutineInfo() {
    }

    public RoutineInfo(String clsTitl, String clsCode, String clsTime, String clsTech, String clsRoom) {
        this.clsTitl = clsTitl;
        this.clsCode = clsCode;
        this.clsTime = clsTime;
        this.clsTech = clsTech;
        this.clsRoom = clsRoom;
    }

    public String getClsTitl() {
        return clsTitl;
    }

    public String getClsCode() {
        return clsCode;
    }

    public String getClsTime() {
        return clsTime;
    }

    public String getClsTech() {
        return clsTech;
    }

    public String getClsRoom() {
        return clsRoom;
    }


    public void setClsTitl(String clsTitl) {
        this.clsTitl = clsTitl;
    }

    public void setClsCode(String clsCode) {
        this.clsCode = clsCode;
    }

    public void setClsTime(String clsTime) {
        this.clsTime = clsTime;
    }

    public void setClsTech(String clsTech) {
        this.clsTech = clsTech;
    }

    public void setClsRoom(String clsRoom) {
        this.clsRoom = clsRoom;
    }
}
