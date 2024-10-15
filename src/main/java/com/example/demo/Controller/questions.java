package com.example.demo.Controller;

import com.example.demo.Service.service;
import com.example.demo.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class questions {
    @Autowired
    service service;
    @RequestMapping("allQuestions")
    public ResponseEntity<List<question>> getallquestions(){
        return service.getallquestions();
    }
    @RequestMapping("difflevel/{level}")
    public ResponseEntity<List<question>> getdifflevel(@PathVariable String level){
        return service.getdifflevel(level);
    }
    @PostMapping("add")
    public ResponseEntity<String> addquestion(@RequestBody question q){
        return service.addquestion(q);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<String> delquestion(@PathVariable int id){
        return service.delquestion(id);
    }

    @PutMapping("update")
    public ResponseEntity<String> updatequestion(@RequestBody question q){
        return service.updatequestion(q);
    }

}
