package seu.edu.bd.springbootdemoshohag.repository;

import org.springframework.data.repository.CrudRepository;
import seu.edu.bd.springbootdemoshohag.model.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
 List<Student>findByName(String name);

 List<Student> findAllByNameContains(String partial);
}
