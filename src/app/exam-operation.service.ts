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
  updateScoreByExamIdEndPoint:string=this.baseURL+'/exam';


  constructor(private http: HttpClient) { }


  addExam(examDto:ExamDto):Observable<ExamDto>{
    console.log("inside service: "+ExamDto);
    return this.http.post<ExamDto>(`${this.addExamEndPoint}`,examDto);
  }



  UdateScoreByExamId(examId:number):Observable<ExamDto>{

   console.log("inside the method :"+examId);
    
     let updateScoreByExamIdEndPoint='';
    
     let examFromDB:ExamDto=new ExamDto(0,0,0,0,0,'');
    
     updateScoreByExamIdEndPoint =this.baseURL+'/items/'+examId;
    
   return this.http.put<ExamDto>(`${updateScoreByExamIdEndPoint}`,examFromDB);
    
   }




  // public updateScoreByExamId(examId: number) {
  //   // let endPoints = "/posts/1"
  //   this.http.put(`${this.updateScoreByExamIdEndPoint}`, examId).subscribe((data: any) => {
  //     console.log(data);
  //   });
  }



  // updateScoreByExamId(examId:number):Observable<ExamDto[]>{
  //   // console.log("Inside Method 1 "+this.updateScoreByExamIdEndPoint);
  //   this.updateScoreByExamIdEndPoint=this.updateScoreByExamIdEndPoint+'/'+examId;
  //   // console.log("Inside Method 2 "+this.updateScoreByExamIdEndPoint);
  //   return this.$http.put<ExamDto[]>(`${this.updateScoreByExamIdEndPoint}`);
  // }

//   ngOnInit(examId:number){
//     const body = { title: 'Angular PUT Request Example' };
//     this.http.put<ExamDto[]>(`${this.updateScoreByExamIdEndPoint}`, examId)
//         // .subscribe(data => this.updateScoreByExamIdEndPoint= data.);
// }


