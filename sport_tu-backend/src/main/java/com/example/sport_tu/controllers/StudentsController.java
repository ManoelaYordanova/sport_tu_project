package com.example.sport_tu.controllers;

import com.example.sport_tu.entities.Students;
import com.example.sport_tu.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    StudentsRepo studentsRepo;

    @GetMapping("")
    public List<Students> getStudents() {

        return studentsRepo.findAll();

    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getStudent(@PathVariable("id") Long id) {
        return studentsRepo.findById(id).toString();
    }

    @GetMapping("/search/name")
    public  List<Students> getStudentsName(@RequestParam(required = false) String firstName) {
        List<Students> result = studentsRepo.findStudentsByFirstName(firstName.toLowerCase());

        if(result.isEmpty()) {
            ResponseEntity.ok("Въведеното име не е намерено!");
        }
        else
            return  result;

        return  null;
    }

    @PostMapping("/save")
    public  ResponseEntity saveOrUpdateStudents(@RequestBody Students form) {
        Boolean isNew = studentsRepo.findByEmail(form.getEmail().toLowerCase()).isEmpty();
        Map<String, Object> p = new HashMap<>();
        if(isNew) {
            p.put("message", "Успешно записан!");
            p.put("student", studentsRepo.save(form));
        }
        else
        {
            p.put("message", "Успешно редактиран!");
            Optional<Students> s = studentsRepo.findByEmail(form.getEmail());
            studentsRepo.delete(s.orElse(null));
            p.put("student", studentsRepo.save(form));
        }

        return  new ResponseEntity<>(p , HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(@RequestParam Long id) {
        Students student = studentsRepo.getOne(id);
        studentsRepo.delete(student);
        return ResponseEntity.ok("Успешно изтрит!");
    }
}