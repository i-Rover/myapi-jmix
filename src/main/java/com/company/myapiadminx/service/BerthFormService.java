package com.company.myapiadminx.service;

import com.company.myapiadminx.entity.BerthForm;
import com.company.myapiadminx.entity.WorkProgram;
import com.company.myapiadminx.requestmodels.BerthAndWorkProgram;
import io.jmix.core.DataManager;
import io.jmix.core.FileRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;

@Service
@Transactional
public class BerthFormService {
    @Inject
    private DataManager dataManager;
    public void createBerthFormAndUploadFile(String berthName, MultipartFile file){
        BerthForm berthForm = dataManager.create(BerthForm.class);
        berthForm.setBerthName(berthName);
        berthForm.setFileName((FileRef) file);
        dataManager.save(berthForm);
    }

    public void createBerthAndWorkProgram(BerthAndWorkProgram berthAndWorkProgram){
        BerthForm berthForm = dataManager.create(BerthForm.class);
        berthForm.setBerthName(berthAndWorkProgram.getBerthName());
        WorkProgram workProgram = dataManager.create(WorkProgram.class);
        workProgram.setWorkProgram(berthAndWorkProgram.getWorkProgram());
        workProgram.setBerthForm(berthForm);
        dataManager.save(berthForm);
        dataManager.save(workProgram);
    }
}
