package com.query.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.query.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	List<Employee>  findByDeptno(Integer deptno);
	
	@Query("select e.ename, e.sal from Employee e order by e.ename asc")
	List<Object[]>  readEmployees();
	
	List<Employee>  getEmployeesBySal(@Param("empsal") double  sal);
	
	@Modifying
	@Transactional
	@Query("update  Employee e  set e.sal=?1 where e.deptno=?2")
	int updateEmployees(double sal, int deptno);
	

}
