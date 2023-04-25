package in.chedly.courseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.chedly.courseproject.entity.Employee;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Long> {

}
