package com.company.myapiadminx.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.Store;
import io.jmix.data.DbView;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Store(name = "postgres")
@DbView
@JmixEntity
@Table(name = "viewworkprogram")
@Entity
public class Viewworkprogram {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "berth_name")
    private String berthName;

    @Column(name = "work_program")
    private String workProgram;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWorkProgram() {
        return workProgram;
    }

    public void setWorkProgram(String workProgram) {
        this.workProgram = workProgram;
    }

    public String getBerthName() {
        return berthName;
    }

    public void setBerthName(String berthName) {
        this.berthName = berthName;
    }
}