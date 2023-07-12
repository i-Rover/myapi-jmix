package com.company.myapiadminx.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "WORK_PROGRAM", indexes = {
        @Index(name = "IDX_WORK_PROGRAM_BERTH_FORM", columnList = "BERTH_FORM_ID")
})
@Entity
public class WorkProgram {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "WORK_PROGRAM")
    private String workProgram;

    @JoinColumn(name = "BERTH_FORM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private BerthForm berthForm;

    public BerthForm getBerthForm() {
        return berthForm;
    }

    public void setBerthForm(BerthForm berthForm) {
        this.berthForm = berthForm;
    }

    public String getWorkProgram() {
        return workProgram;
    }

    public void setWorkProgram(String workProgram) {
        this.workProgram = workProgram;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}