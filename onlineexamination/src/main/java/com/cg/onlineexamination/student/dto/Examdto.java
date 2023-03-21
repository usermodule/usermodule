package com.cg.onlineexamination.student.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.onlineexamination.entity.TestPaper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Examdto {
	
	private int examId;
	private int score;
    private LocalDate dateOfExam;
    
//	private int testId;
//	private int questionNo;
	private ArrayList<String> studAnswer;
	
	

}