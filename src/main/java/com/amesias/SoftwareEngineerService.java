package com.amesias;

import com.amesias.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> findAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insert(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer findSoftwareEngineer(int id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("id " + id + " Not Found"));
    }
}
