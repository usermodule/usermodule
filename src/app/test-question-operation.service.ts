import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TestQuestionDto } from './test-question-dto';

@Injectable({
  providedIn: 'root'
})
export class TestQuestionOperationService {
  baseURL:string = 'http://localhost:2025';

  getAllQuestionsEndPoint:string=this.baseURL+'/testQuestion/list';
  getQuestionByTestPaperIdEndPoint:string=this.baseURL+'/testQuestion/getAllQuestion';
  constructor(private http: HttpClient) { }


  getAllQuestion():Observable<TestQuestionDto[]>
  {
    console.log("inside service : "+this.getAllQuestionsEndPoint);
    return this.http.get<TestQuestionDto[]>(`${this.getAllQuestionsEndPoint}`);
  }

  

  getAllQuestionsByTestPaperId(testPaperId:number):Observable<TestQuestionDto[]>{
    console.log("Inside Method 1 "+this.getQuestionByTestPaperIdEndPoint);
    this.getQuestionByTestPaperIdEndPoint=this.getQuestionByTestPaperIdEndPoint+'/'+testPaperId;
    console.log("After  "+this.getQuestionByTestPaperIdEndPoint);

    return this.http.get<TestQuestionDto[]>(`${this.getQuestionByTestPaperIdEndPoint}`);
  }


}
