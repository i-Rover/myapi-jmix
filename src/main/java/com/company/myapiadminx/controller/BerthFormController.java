package com.company.myapiadminx.controller;

import com.company.myapiadminx.service.BerthFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/BerthForms")
public class BerthFormController {
    @Autowired
    private BerthFormService berthFormService;
    @PostMapping("/RequireAccess/create")
    public void createBerthFormAndUploadFile(@RequestHeader(value="Authorization")String token, @RequestParam String berthName,
                                             @RequestBody MultipartFile file)throws Exception{
        berthFormService.createBerthFormAndUploadFile(berthName, file);
    }
}
