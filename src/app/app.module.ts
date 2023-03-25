import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddExamComponent } from './add-exam/add-exam.component';
import { ViewQuestionComponent } from './view-question/view-question.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AddQuestionComponent } from './add-question/add-question.component';

const allLinks:Routes = [
  {path: 'aboutUs',component: AboutUsComponent},
  {path: 'viewQuestion',component: ViewQuestionComponent},
  {path:'addTestPaper',component: AddExamComponent}
  
]

@NgModule({
  declarations: [
    AppComponent,
    AddExamComponent,
    ViewQuestionComponent,
    AboutUsComponent,
    AddQuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(allLinks),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
