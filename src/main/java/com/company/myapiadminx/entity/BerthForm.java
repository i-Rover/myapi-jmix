package com.company.myapiadminx.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.Store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Store(name = "postgres")
@JmixEntity
@Table(name = "BERTH_FORM")
@Entity
public class BerthForm {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "BERTH_NAME")
    private String berthName;

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