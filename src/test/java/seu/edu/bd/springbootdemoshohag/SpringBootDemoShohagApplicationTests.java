package seu.edu.bd.springbootdemoshohag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seu.edu.bd.springbootdemoshohag.model.Student;
import seu.edu.bd.springbootdemoshohag.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringBootDemoShohagApplicationTests {
	@Autowired
  private StudentRepository studentRepository;
	@Test
	void contextLoads() {
	}


	@Test
	void createStudents(){
		Student student = new Student();
		student.setId(21344L);
		student.setName("Md. Ashiqur Rahman");
		student.setCgpa(3.99);

		Student savedStudent = studentRepository.save(student);
		System.out.println(savedStudent);
		Assertions.assertEquals(student.getId(), savedStudent.getId());
		Assertions.assertEquals(student.getName(), savedStudent.getName());
		Assertions.assertEquals(student.getCgpa(), savedStudent.getCgpa(),0.001);

	}



	@Test
	void readStudents(){
		Iterable<Student> studentIterable = studentRepository.findAll();
		List<Student> studentList= new ArrayList<>();
		studentIterable.forEach(studentList::add);
		System.out.println(studentList);
		//System.out.println(studentList.size()+ "students");


	}

	@Test
	public void readStudentByName(){
		Student student = new Student();
		student.setId(10001L);
		student.setName("shohag pk");
		student.setCgpa(3.20);
		studentRepository.save(student);


		student.setId(10002L);
		student.setName("Rony");
		student.setCgpa(3.50);
		studentRepository.save(student);

		student.setId(10003L);
		student.setName("Hridoy fokir");
		student.setCgpa(3.60);
		studentRepository.save(student);

		student.setName("Monirul");
		student.setCgpa(3.60);
		studentRepository.save(student);

		List<Student> studentList = studentRepository.findByName("Monirul");
        studentList.stream().forEach(System.out::println);
	}

	@Test
	public void readStudentByPartialNameMatch(){
		Student student = new Student();
		student.setId(10001L);
		student.setName("shohag pk");
		student.setCgpa(3.20);
		studentRepository.save(student);


		student.setId(10002L);
		student.setName("Rony");
		student.setCgpa(3.50);
		studentRepository.save(student);

		student.setId(10003L);
		student.setName("Hridoy fokir");
		student.setCgpa(3.60);
		studentRepository.save(student);

		student.setId(10004L);
		student.setName("Monirul");
		student.setCgpa(3.60);
		studentRepository.save(student);

		student.setId(10005L);
		student.setName("Monikul");
		student.setCgpa(3.10);
		studentRepository.save(student);

		List<Student> studentList = studentRepository.findAllByNameContains("Mon");
		studentList.stream().forEach(System.out::println);
	}
}
