package com.cg.onlineexamination.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.dto.Examdto;
import com.cg.onlineexamination.student.dto.TestQuestiondto;
import com.cg.onlineexamination.student.exception.ExamNotFoundException;

@Service
public interface ExamService  {
	
	
	public Exam addExam(Exam exam)throws Exception;
	
	
	public Exam getExambyId(int Id)throws Exception;
	public List<Exam>getAllExams();
	public Exam updateTestPaper(int examId , int testPaperId);
	
	
	public Exam updateStudentAnswer(int examId, Examdto examdto) throws ExamNotFoundException;
	
	
	public int evaluateScore(List<TestQuestion> testQuestion, List<String> studentAnswers);
	
//	public Exam getStudentAnswerByExamId( int examId);


	
	
	
	
	//public Exam startExam(int examId);
	/*public Exam findResultByEnrollmentId(int enrollmentId);
	List<Exam> findAllResultsByBatchName(String batchName);
	boolean releaseResultByEnrollmentId(int enrollmentId); */

}