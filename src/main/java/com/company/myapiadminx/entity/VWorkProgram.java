package com.company.myapiadminx.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.data.DbView;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@DbView
@JmixEntity
@Table(name = "v_work_program")
@Entity
public class VWorkProgram {
    @JmixGeneratedValue
    @Column(name = "berth_id", nullable = false)
    @Id
    private UUID id;

    @Column(name = "berth_name")
    private String berthName;

    @Column(name = "work_program_id")
    private UUID workProgram;

    @Column(name = "work_program")
    private String workProgram1;

    public String getWorkProgram1() {
        return workProgram1;
    }

    public void setWorkProgram1(String workProgram1) {
        this.workProgram1 = workProgram1;
    }

    public UUID getWorkProgram() {
        return workProgram;
    }

    public void setWorkProgram(UUID workProgram) {
        this.workProgram = workProgram;
    }

    public String getBerthName() {
        return berthName;
    }

    public void setBerthName(String berthName) {
        this.berthName = berthName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}