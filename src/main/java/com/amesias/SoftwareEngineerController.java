package com.amesias;

import com.amesias.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;
    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping("/")
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.findAllSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSoftwareEngineerById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(softwareEngineerService.findSoftwareEngineer(id));
        }catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping("/")
    public void addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insert(softwareEngineer);
    }
}
