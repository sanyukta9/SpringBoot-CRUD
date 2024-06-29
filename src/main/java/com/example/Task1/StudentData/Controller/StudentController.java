package com.example.Task1.StudentData.Controller;

import com.example.Task1.StudentData.Entity.Student;
import com.example.Task1.StudentData.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    // URL: http://localhost:8080/api/get
    @GetMapping("/get")
    public ResponseEntity<Object> getStudent() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(students);
        }
    }

    // Save a new student(single)
    // URL: http://localhost:8080/api/save
    @PostMapping("/save")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student record saved!");
    }

    // Save all new students(multiple)
    /*
    [
    {
        "studFname": "Sanyukta",
        "studLname": "Adhate",
        "courseName": "Java"
    },
    {
        "studFname": "John",
        "studLname": "Doe",
        "courseName": "Python"
    },
    {
        "studFname": "Jane",
        "studLname": "Smith",
        "courseName": "JavaScript"
    },
    {
        "studFname": "Emily",
        "studLname": "Davis",
        "courseName": "C++"
    },
    {
        "studFname": "Michael",
        "studLname": "Brown",
        "courseName": "Ruby"
    }
    ]
     */
    // URL: http://localhost:8080/api/saveAll
    @PostMapping("/saveAll")
    public ResponseEntity<Object> saveAll(@RequestBody List<Student> students) {
        studentRepository.saveAll(students);
        return ResponseEntity.status(HttpStatus.OK).body("Student records saved!");
    }

    // Update an existing student
    // URL: http://localhost:8080/api/update/{id}
    /*
    {
    "studId": 102,
    "studFname": "sanyukta",
    "studLname": "adhate",
    "courseName": "Java"
    }
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            student.setStudId(studentOptional.get().getStudId());
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.OK).body("Student record updated for id " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not updated for id " + id);
        }
    }

    // Delete a student by ID
    // URL: http://localhost:8080/api/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Student record deleted for id " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found for id " + id);
        }
    }

    // Delete all students
    // URL: http://localhost:8080/api/deleteAll
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll() {
        studentRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All student records deleted successfully!");
    }
}
