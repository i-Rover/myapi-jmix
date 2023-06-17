package com.company.myapiadminx.service;

import com.company.myapiadminx.dao.WorkProgramRepository;
import com.company.myapiadminx.entity.WorkProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class WorkProgramService {
    @Autowired
    private WorkProgramRepository workProgramRepository;
    public String hiThere(){
        return "Hi there";
    }
    public Optional<WorkProgram> findWorkProgramAndBerthForm(UUID id){
        return workProgramRepository.findWorkProgramAndBerthForm(id);
    }
    public Page<WorkProgram> findAll(Pageable pageable){
        return workProgramRepository.findAll(pageable);
    }
}
