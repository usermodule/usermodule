import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExamDto } from './exam-dto';

@Injectable({
  providedIn: 'root'
})
export class ExamOperationService {
  baseURL:string = 'http://localhost:2025';

  addExamEndPoint:string=this.baseURL+'/exam/add';
  constructor(private http: HttpClient) { }


  addExam(examDto:ExamDto):Observable<ExamDto>{
    console.log("inside service: "+ExamDto);
    return this.http.post<ExamDto>(`${this.addExamEndPoint}`,examDto);
  }

}
