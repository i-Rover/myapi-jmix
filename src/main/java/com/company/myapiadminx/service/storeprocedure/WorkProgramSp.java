package com.company.myapiadminx.service.storeprocedure;

import com.company.myapiadminx.dao.WorkProgramRepository;
import com.company.myapiadminx.entity.BerthForm;
import com.company.myapiadminx.responsemodels.WorkBerthProgramModel;
import com.company.myapiadminx.responsemodels.WorkProgramBerthFormModel;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Service
@Transactional
public class WorkProgramSp {
    @Autowired
    private WorkProgramRepository workProgramRepository;
    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;
    @Autowired
    private DataManager dataManager;

    public List<WorkBerthProgramModel> sp_work_program_w_param(){
        String myOBJs = "Transport Palm Oil";
        List<WorkBerthProgramModel> workBerthProgramModels = workProgramRepository.updateStoreProcedure(myOBJs);
        return workBerthProgramModels;
    }
}
