package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Employee;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.EmployeeRepository;
import com.tracom.officeplanner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    //Save Employee
    public void saveEmployee(Employee employee){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(employee.getPassword());
            employee.setPassword(encodedPassword);

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

    //finding employee by firstname and lastname

//    public void assignEmail(Long id){
//        Employee employee = employeeRepository.getEmployeeById(id).orElse(null);
//        User user = userRepository.findByFirstnameAndLastname(
//                employee.getEmp_firstname(),
//                employee.getEmp_lastname()
//        );
//        employee.setEmp_email(user.getEmail());
//        employeeRepository.save(employee);
//    }
}
