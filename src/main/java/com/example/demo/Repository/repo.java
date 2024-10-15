package com.example.demo.Repository;

import com.example.demo.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface repo extends JpaRepository<question,Integer> {
    List<question> findByDifficultyLevel(String level);
}




