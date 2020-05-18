package seu.edu.bd.springbootdemoshohag.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.edu.bd.springbootdemoshohag.model.Student;
import seu.edu.bd.springbootdemoshohag.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("")
    public List<Student> getstudents() {

        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.forEach(studentList::add);

        return studentList;
    }
    @GetMapping("/{id}")
    public Student getstudent(@PathVariable long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

}
