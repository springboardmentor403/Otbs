package com.otbs.controller;

import com.otbs.model.HelpDeskExecutive;
import com.otbs.service.ComplaintService;
import com.otbs.service.HelpDeskExecutiveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helpdesk-executives")
public class HelpDeskExecutiveController {

    @Autowired
    private HelpDeskExecutiveService helpdeskExecutiveService;
    
    public HelpDeskExecutiveController(HelpDeskExecutiveService helpdeskExecutiveService) {
    	this.helpdeskExecutiveService=helpdeskExecutiveService;
    }
    

    // Add a new help desk executive
    @PostMapping("/emp")
    public HelpDeskExecutive addHelpDeskExecutive(@RequestBody HelpDeskExecutive executive) {
        return helpdeskExecutiveService.addHelpDeskExecutive(executive);
    }

    // View all help desk executives
    @GetMapping
    public List<HelpDeskExecutive> getAllHelpDeskExecutives() {
        return helpdeskExecutiveService.getAllHelpDeskExecutives();
    }
}