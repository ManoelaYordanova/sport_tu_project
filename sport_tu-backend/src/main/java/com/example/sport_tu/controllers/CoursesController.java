package com.example.sport_tu.controllers;

import com.example.sport_tu.entities.Courses;
import com.example.sport_tu.repositories.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesRepo coursesRepo;

    @GetMapping("")
    public List<Courses> getCourses() {
        return coursesRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getCourses(@PathVariable("id") Long id) {
        return coursesRepo.findById(id).toString();
    }

    @PutMapping("/save")
    public Courses saveOrUpdateCourses(@RequestBody Courses course) {
        coursesRepo.save(course);
        return course;
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteCourse(@PathVariable("id") Long id) {
        Courses course = coursesRepo.getOne(id);
        coursesRepo.delete(course);
        return "deleted";
    }
}
