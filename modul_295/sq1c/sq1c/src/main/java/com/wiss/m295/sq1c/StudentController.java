package com.wiss.m295.sq1c;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<String> students = new ArrayList<>();

    public StudentController(){
        students.add("Max");
        students.add("Lisa");
    }

    @GetMapping("/")
    public List<String> getStudents(){
        return students;
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteStudent(@RequestParam String name){

        System.out.println("DELETE Request for name: " + name);
        boolean result = students.remove(name);

        return result == true ? ResponseEntity.ok("deleted") : ResponseEntity.notFound().build();

    }

    /**
     * Add a new student
     * curl -X POST http://localhost:8080/student \
     -H "Content-Type: text/plain" \
     -d "Max Muster"
     * @param name
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody String name){

        System.out.println("POST Request for name: " + name);
        boolean result = students.add(name);

        return result == true ? ResponseEntity.ok("added") : ResponseEntity.notFound().build();
    }
}
