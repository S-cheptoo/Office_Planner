package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Department;
import com.tracom.officeplanner.Models.Organization;
import com.tracom.officeplanner.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //save
    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }
    //List
    public List<Department> listDepartments(){
        return departmentRepository.findAll();
    }

    //Delete
    public void deleteDepartment(Long dp_id){
        departmentRepository.deleteById(dp_id);
    }

    //Editing
    public Department editDepartment(Long dp_id){
        return departmentRepository.getDepartmentById(dp_id);
    }

    public Department getDepartmentById(Long dp_id){
        Department department = departmentRepository.getDepartmentById(dp_id);
        return department;
    }
}
