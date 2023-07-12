package com.company.myapiadminx.responsemodels;

public class BerthWorkProgramModel {
    private String berthName;
    private String workProgram;

    private Object rows;

    public BerthWorkProgramModel(Object rows) {
        this.rows = rows;
    }

    public String getBerthName() {
        return berthName;
    }

    public void setBerthName(String berthName) {
        this.berthName = berthName;
    }

    public String getWorkProgram() {
        return workProgram;
    }

    public void setWorkProgram(String workProgram) {
        this.workProgram = workProgram;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
