package com.cg.onlineexamination.student.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.student.dto.Examdto;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer>{

	

//	Exam updateTestpaper(Exam savedExam, TestPaper savedTestPaper);

	

//	Exam updateTestpaper(Exam savedExam, TestPaper savedTestPaper);
}
