package com.example.studentapi;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    StudentRepository repository = new InMemoryStudentRepository();

    //REST ENDPOINTS
    //CREATE A STUDENT
    @PostMapping("/student")
    public void createStudent(@RequestBody Student student) {

        repository.save(student);


        //logic to save the student in database


        System.out.println("name:" + student.name);
        System.out.println("age:" + student.age);
        System.out.println("id:" + student.id);

    }

    //retrieve student
    @GetMapping("/student/:{id}")
    public  Student getStudent(@PathVariable String id){

        return  repository.get(id);

    }
    //delete a student
    @DeleteMapping("student/{id}")
    public  Student deleteStudent(@PathVariable String id){
        return repository.deleteStudent(id);
    }
    //update a student


}
