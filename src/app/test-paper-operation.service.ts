import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TestPaper } from './test-paper';

@Injectable({
  providedIn: 'root'
})
export class TestPaperOperationService {


  baseURL:string = 'http://localhost:2025';

  addTestPaperEndPoint:string=this.baseURL+'/testPaper';


  constructor(private http:HttpClient) { }

  addTestPaper(testPaper:TestPaper):Observable<TestPaper>{
    console.log("inside service: "+testPaper);
    return this.http.post<TestPaper>(`${this.addTestPaperEndPoint}`,testPaper);
  }


}
