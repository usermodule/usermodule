import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from '../exam';
import { ExamDto } from '../exam-dto';
import { ExamOperationService } from '../exam-operation.service';
import { TestQuestion } from '../test-question';
import { TestQuestionDto } from '../test-question-dto';
import { TestQuestionOperationService } from '../test-question-operation.service';

@Component({
  selector: 'app-start-exam',
  templateUrl: './start-exam.component.html',
  styleUrls: ['./start-exam.component.css']
})
export class StartExamComponent {

  status=false;
  msg=' ';
  

  testQuestion: TestQuestion= new TestQuestion(0,'','','','','','');
exam : Exam=new Exam(0,0,0,'');
  testQuestionDto: TestQuestionDto[]=[];
  examDto: ExamDto[]=[];
  testPaperId: number = 0;
  examId: number=0;
  constructor(private testQuestionService: TestQuestionOperationService, private router: Router,private examService:ExamOperationService){
   
  }

  getTestQuestionById(){
  //  this.testQuestionDto=[];
    // let testPaperId:number=parseInt(tId);
    this.testQuestionService.getAllQuestionsByTestPaperId(this.testPaperId).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.testQuestionDto = data;
      },err=>{
        console.log("error from spring ",err);

      }
    );
  }

 

  updateScore(){

    this.examService.UdateScoreByExamId(this.examId).subscribe(
   
         
   data=>{
    
     this.status=true;
    
   this.msg="Score updated";
  },
    
  err=>{
    console.log("error from spring ",err);

      }
    );

      alert("Success! Question Added");
      localStorage.setItem('pData',JSON.stringify(this.testQuestion));

    }

  // updateScoreByExamId(){
  //   //  this.testQuestionDto=[];
  //     // let testPaperId:number=parseInt(tId);
  //     this.examService.updateScoreByExamId(this.examId)
        
  //     alert("Success! Question Added");
  //     localStorage.setItem('pData',JSON.stringify(this.examDto));
  //   }

  
}
