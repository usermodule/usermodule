package com.cg.onlineexamination.student.service;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.dto.Examdto;
import com.cg.onlineexamination.student.dto.TestQuestiondto;
import com.cg.onlineexamination.student.exception.ExamNotFoundException;
import com.cg.onlineexamination.student.repository.ExamRepository;
import com.cg.onlineexamination.student.repository.IStudentRepository;
import com.cg.onlineexamination.student.repository.TestPaperRepository;
import com.cg.onlineexamination.student.repository.TestQuestionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExamServiceImpl implements ExamService{


	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	TestPaperRepository testPaperRepository;
	
	@Autowired
	IStudentRepository studentRpository;
	
	@Autowired
	TestQuestionRepository testQuestionRepository;

	
	
	
	
//	@Override
//	public Examdto getStudentAnswer(Examdto examdto) throws Exception {
//		
//		if(examdto != null) {
//			if(examdto.getStudAnswer().equals("") && examdto.getQuestionNo()==0) {
//				throw new InvalidClassException("Answer is required", "Question No. is required");
//			}
//			
//			}
//		return null;
//	}
	
	
	

	
  
	@Override
	public Exam addExam(Exam exam) throws Exception {
		if (exam != null) {
			if (exam.getDateOfExam().equals(" ")) {
				throw new InvalidClassException("exam", "exam is null");
			}
			Exam savedExam = examRepository.save(exam);
			return savedExam;
		} else
			
			throw new NullPointerException("exam is null");
	}

	
	
	@Override
	public List<Exam> getAllExams() {
		return examRepository.findAll();
	}

	@Override
	public Exam getExambyId(int id) {
		
		if (id>=1) {
			Exam savedExam = examRepository.getReferenceById(id);
			if(savedExam != null)
				return savedExam;
			else {
				throw new EntityNotFoundException("Invalid Exam Id: "+ id);
				
			}
			
			
		}
		return null;
		
	}

	@Override
	public Exam updateTestPaper(int examId, int testPaperId) {
		Exam savedExam = examRepository.getReferenceById(examId);
		TestPaper savedTestPaper = testPaperRepository.getReferenceById(testPaperId);

		
		if(savedExam != null & savedTestPaper != null) 
		{
			savedExam.setTestpaper(savedTestPaper);
			return savedExam;
		}

		return null;
	}




//	@Override
//	public Exam getStudentAnswerByExamId( int examId) {
//		Exam exam  = examRepository.getReferenceById(examId);
//		ArrayList<String> savedExam = new ArrayList<>();
//		
//		exam.setStudentAnswer(savedExam);
//		 
//		return exam;
//	}



	@Override
	public Exam updateStudentAnswer(int examId, Examdto examdto) throws ExamNotFoundException {
		Exam exam = examRepository.getReferenceById(examId);
		if(exam==null){
			
		throw new ExamNotFoundException("Exam not found");
		}
		exam.setStudentAnswer(examdto.getStudAnswer());
		exam.setScore(evaluateScore(exam.getTestpaper().getTestQuestion(), examdto.getStudAnswer()));
		
		Exam e = examRepository.save(exam);
		
		return e;
	}



@Override
public int evaluateScore(List<TestQuestion> testQuestion, List<String> studentAnswers) {
	int score = 0;
	int i=0;
	for (TestQuestion tq1 : testQuestion) {
		
	if(	tq1.getCorrectAnswer().equals(studentAnswers.get(i))){
		score++;
	}
		
	}
	
	return score;
}



  
}





	/*@Override
	public Exam startExam(int examId) {
		
	}
	}*/
	
	/*@Override
	public Exam findResultByEnrollmentId(int enrollmentId) throws ExamNotFoundException {
		 Exam result = examRepository.findByEnrollmentId(enrollmentId);
		    if (result == null) {
		        throw new ExamNotFoundException("Exam not found for enrollment ID: " + enrollmentId);
		    }
		    return result;
		
	}
	@Override
	public List<Exam> findAllResultsByBatchName(String batchName) throws ExamNotFoundException {
		 List<Exam> examResults = examRepository.findAllByBatchName(batchName);
		    if (examResults.isEmpty()) {
		        throw new ExamNotFoundException("No exams found for batch name: " + batchName);
		    }
		    return examResults;
	}
	
	   
	
	@Override
	public boolean releaseResultByEnrollmentId(int enrollmentId) {
		// TODO Auto-generated method stub
		return false;
	} */
	