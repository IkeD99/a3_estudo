package com.a3_estudo.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.a3_estudo.web.entities.Department;

public interface DepartRepository extends JpaRepository<Department, Long>{

}