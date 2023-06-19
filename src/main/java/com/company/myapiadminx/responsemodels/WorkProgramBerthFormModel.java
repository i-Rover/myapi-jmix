package com.company.myapiadminx.responsemodels;

import java.util.UUID;

public class WorkProgramBerthFormModel {
    private UUID berth_form_id;
    private UUID work_program_id;
    private String work_program;
    private String berth_name;

    public void setWork_program(){this.work_program=work_program;}
    public String getWork_program(){return work_program;}
    public void setBerth_name(){this.berth_name=berth_name;}
    public String getBerth_name(){return berth_name;}
    public void setBerth_form_id(){this.berth_form_id=berth_form_id;}
    public UUID getBerth_form_id(){return berth_form_id;}
    public void setWork_program_id(){this.work_program_id=work_program_id;}
    public UUID getWork_program_id(){return work_program_id;}
}
