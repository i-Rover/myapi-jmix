package com.company.myapiadminx.service.storeprocedure;

import com.company.myapiadminx.dao.WorkProgramRepository;
import com.company.myapiadminx.entity.BerthForm;
import com.company.myapiadminx.responsemodels.BerthWorkProgramModel;
import com.company.myapiadminx.responsemodels.WorkBerthProgramModel;
import com.company.myapiadminx.responsemodels.WorkProgramBerthFormModel;
import io.jmix.core.DataManager;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;

import javax.persistence.*;
import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WorkProgramSp {
    @Autowired
    private WorkProgramRepository workProgramRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private DataManager dataManager;

    @Transactional
    public void updateWorkProgramStoreProcedure()throws Exception{
        String workProgramType = "Transport Oil & Water";
        String workProgramName = "Transport Water Only";
        String postgresSql = "call update_work_program(?,?)";
        entityManager.createNativeQuery(postgresSql)
                .setParameter(1,workProgramType)
                .setParameter(2,workProgramName)
                .executeUpdate();
    }

    public List<BerthWorkProgramModel> functionBerthFormAndWorkProgram()throws Exception {
        List<BerthWorkProgramModel> berthWorkProgramModel = new ArrayList<>();
        String mySQL = "select * from public.bfwp()";
        List list = entityManager.createNativeQuery(mySQL)
                .getResultList();

        for (Object o : list) {
            berthWorkProgramModel.add(new BerthWorkProgramModel(o));
        }

        return berthWorkProgramModel;
    }
    public void callMyStoredProcedure(){
        String workProgramType = "Transport Oil & Water";

        String myNativeQueries = "CREATE OR REPLACE PROCEDURE public.update_work_program(IN work_program_type character varying)\n" +
                  " LANGUAGE plpgsql\n" +
                  "AS $procedure$\n" +
                  "\tBEGIN\n" +
                  "\tupdate work_program \n" +
                  "\tset work_program = 'Transport Palm Oil'\n" +
                  "\twhere work_program = work_program_type;\n" +
                  "\tEND;\n" +
                  "$procedure$\n" +
                  ";\n";
        StoredProcedureQuery storedProcedureQuery =
          entityManager.createStoredProcedureQuery(myNativeQueries)
                  .registerStoredProcedureParameter("work_program_type", String.class, ParameterMode.IN)
                        .setParameter("work_program_type", workProgramType);
        storedProcedureQuery.execute();
    }
}
