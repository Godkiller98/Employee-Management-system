package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepo;
@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;
	
public void addemp(Employee e) 
{
	repo.save(e);
	}

public List<Employee> getAllEmp(){
	
	return repo.findAll();
}




 public Employee getEmpById(int id) {
	Optional<Employee> e =repo.findById(id);
	if(e.isPresent()) {
		return e.get();
	}return null;
 }
 
// public Employee getEmpByName(String name) {
//	 return repo.findByName(name);
//	 
// }
public void delete(int id) {
	repo.deleteById(id);
	
}
public Employee empedit(Employee e) {
	Employee existingEmployee=repo.findById(e.getId()).orElse(null);
     existingEmployee.setName(e.getName());
     existingEmployee.setAddress(e.getAddress());
     existingEmployee.setEmail(e.getEmail());
     existingEmployee.setPhone(e.getPhone());
     existingEmployee.setSalary(e.getSalary());
     return repo.save(existingEmployee);

}
}
