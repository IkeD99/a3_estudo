package com.a3_estudo.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a3_estudo.web.entities.Department;
import com.a3_estudo.web.exception.ResourceNotFoundException;
import com.a3_estudo.web.repositories.DepartRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class DepartController {
    
    @Autowired
    private DepartRepository depart_repo;
    
    @GetMapping("/depart")
    public List<Department> getAllDepartments(){
        return depart_repo.findAll();
    }

    @GetMapping("/depart/{id}")
    public ResponseEntity<Department> getDepartById(@PathVariable(value = "id") Long departId) throws ResourceNotFoundException {
        Department depart = depart_repo.findById(departId).orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departId));
        return ResponseEntity.ok(depart);
    }

    @PostMapping("/depart")
    public Department createDepart(@Valid @RequestBody Department depart){
        return depart_repo.save(depart);
    }
    
    @PutMapping("/depart/{id}")
    public ResponseEntity<Department> updateDepart(@PathVariable(value = "id") Long departId, @Valid @RequestBody Department departDetails) throws ResourceNotFoundException {
        Department depart = depart_repo.findById(departId).orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departId));
        
        depart.setName(departDetails.getName());
        final Department updatedDepart = depart_repo.save(depart);
        return ResponseEntity.ok(updatedDepart);
    }

    @DeleteMapping("/depart/{id}")
    public Map<String, Boolean> deleteDepart(@PathVariable(value = "id") Long departId) throws ResourceNotFoundException {
        Department depart = depart_repo.findById(departId).orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departId));
        
        depart_repo.delete(depart);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
