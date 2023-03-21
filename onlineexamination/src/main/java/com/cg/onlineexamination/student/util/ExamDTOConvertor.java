package com.cg.onlineexamination.student.util;

import org.springframework.stereotype.Component;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.student.dto.Examdto;

@Component
public class ExamDTOConvertor {

	public Examdto getExamdto(Exam e)
	{
		return new Examdto(e.getExamId(),e.getScore(),e.getDateOfExam(),e.getStudentAnswer());
	}
	
	
	public Exam getExam(Exam e) {
		return new Exam(e.getDateOfExam());
	}
	
	
	
	}

    