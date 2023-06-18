package com.company.myapiadminx.controller;

import com.company.myapiadminx.entity.WorkProgram;
import com.company.myapiadminx.service.WorkProgramService;
import com.company.myapiadminx.service.util.AuthValidationService;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.security.SystemAuthenticationToken;
import io.jmix.rest.impl.service.UserSessionControllerManager;
import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/WorkPrograms")
public class WorkProgramController {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private WorkProgramService workProgramService;

    @GetMapping("/findWorkProgram")
    public List<WorkProgram> findWorkProgram(@RequestHeader(value="Authorization")String token, @RequestParam("id") UUID id)throws Exception{
        if(token.isBlank()){
            throw new Exception("No token");
        }
        return dataManager.load(WorkProgram.class)
                .query("select e from WorkProgram e where e.id=:id")
                .parameter("id",id)
                .list();
    }

    @GetMapping("/hithere")
    public String hiThere(@RequestHeader(value="Authorization")String token){
        UserDetails user = currentAuthentication.getUser();
        String username = user.getUsername();
        return workProgramService.hiThere();
    }

    @GetMapping("/findWorkProgramAndBerthForm")
    public Optional<WorkProgram> findWorkProgramAndBerthForm(@RequestHeader(value = "Authorization")String token, @RequestParam("id") UUID id)throws Exception{
        if(token.isBlank()){
            throw new Exception("No token");
        }
        return workProgramService.findWorkProgramAndBerthForm(id);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<WorkProgram>> findAll(@RequestHeader(value="Authorization")String token, @RequestParam(value="page", defaultValue = "0")int page, @RequestParam(value="size", defaultValue = "5")int size)throws Exception{
        if(token.isBlank()){
            throw new Exception("No token");
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<WorkProgram> workPrograms = workProgramService.findAll(pageable);
        return ResponseEntity.ok(workPrograms);
    }

    @GetMapping("/allowanonymous")
    public String allowanonymous(){
        return "allowanonymouse";
    }
}
