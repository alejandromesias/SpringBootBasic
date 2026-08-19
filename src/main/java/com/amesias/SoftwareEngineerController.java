package com.amesias;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {
    public SoftwareEngineerController() {}

    @GetMapping("/")
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return List.of(
                new SoftwareEngineer(1, "Name1", "Stack1"),
                new SoftwareEngineer(2, "Name2", "Stack2")
        );
    }
}
