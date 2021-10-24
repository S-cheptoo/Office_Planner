package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Employee;
import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Repository.EmployeeRepository;
import com.tracom.officeplanner.Repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Save Employee
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    //List Employees
    public List<Employee> listEmployees(){
        return employeeRepository.findAll();
    }
    //Delete
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    //Editing
    public Employee editEmployee(long id)
    {
        return employeeRepository.getEmployeeById(id);
    }
}
