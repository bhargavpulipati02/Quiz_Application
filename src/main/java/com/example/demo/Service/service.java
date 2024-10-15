package com.example.demo.Service;

import com.example.demo.Repository.repo;
import com.example.demo.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class service{
    @Autowired
    repo repo;

    public ResponseEntity<List<question>> getallquestions(){
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<question>> getdifflevel(String level) {
        try {
            return new ResponseEntity<>(repo.findByDifficultyLevel(level), HttpStatus.OK);
        }catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addquestion(question q) {
        try {
            repo.save(q);
            return new ResponseEntity<>("Question added successfully", HttpStatus.OK);
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("not added",HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> delquestion(int id) {
        try{
        repo.deleteById(id);
        return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
    }
        catch (Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("not deleted",HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> updatequestion(question q) {
        try{
            repo.save(q);
            return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);

        }
        catch(Exception e){
            e.getStackTrace();
        }
        return new ResponseEntity<>("Question updated unsuccessfully", HttpStatus.BAD_REQUEST);
    }
}
