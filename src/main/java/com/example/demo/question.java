package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                  // Primary key
    private String option_1;          // Option 1
    private String option_2;          // Option 2
    private String option_3;          // Option 3
    private String option_4;          // Option 4
    private String question_4;        // Question text
    private String rightanswer;      // Correct answer
    private String difficultyLevel;


}
