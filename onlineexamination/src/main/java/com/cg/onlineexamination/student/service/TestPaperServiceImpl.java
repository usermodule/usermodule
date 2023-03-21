package com.cg.onlineexamination.student.service;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.student.repository.ExamRepository;
import com.cg.onlineexamination.student.repository.TestPaperRepository;
import com.cg.onlineexamination.student.repository.TestQuestionRepository;

@Service
public class TestPaperServiceImpl implements TestPaperService{

	@Autowired
	TestPaperRepository testPaperRepository;
	
	@Autowired
	TestQuestionRepository testQuestionRepository;
	

	@Override
	public TestPaper addTestPaper(TestPaper t) throws Exception {
		if (t != null) {
			if (t.getDifficultyLevel().equals("")) {
				throw new InvalidClassException("testPaper", "testPaper is null");
			}
			TestPaper savedTestPaper = testPaperRepository.save(t);
			return savedTestPaper;
		} else
			throw new NullPointerException("testPaper is null");
	}

	@Override
	public List<TestPaper> getAllTestPaper() {
		
		return testPaperRepository.findAll();
	}

	@Override
	public List<TestPaper> getTestPaperByCourse(String course) {
		List<TestPaper> allTestPaper = testPaperRepository.findAll();
		List<TestPaper> allTestPaperByCourse = new ArrayList<>();
		for(TestPaper testPaper: allTestPaper) {
			String testPaperCourse = testPaper.getCourse();
			if(testPaperCourse.equals(course)) {
				allTestPaperByCourse.add(testPaper);
			}
		}
		return allTestPaperByCourse;
	}

	@Override
	public int getNoOfQuestionsByTestPaperId(int testPaperId) {
		TestPaper testpaperfromDB = testPaperRepository.getReferenceById(testPaperId);
		if (testpaperfromDB != null) {
			return testpaperfromDB.getNoOfQuestions();
			
		}
		else {
				
		return 0;
	}
	}

	
}

	/*@Override
	public TestPaper updateExam(int testPaperId, int examId) {
		TestPaper savedTestPaper = testPaperRepository.getReferenceById(testPaperId);
		Exam savedExam = examRepository.getReferenceById(examId);
		if(savedTestPaper != null & savedExam != null) 
		{
			TestPaper updatedTestPaper = testPaperRepository.updateExamByTestPaper(savedTestPaper, savedExam);
			testPaperRepository.save(updatedTestPaper);
			return updatedTestPaper;
		}
		else return null;
	}
	}*/
	