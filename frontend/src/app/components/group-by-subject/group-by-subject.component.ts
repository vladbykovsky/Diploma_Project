import { Component, OnInit } from '@angular/core';
import {Student} from "../../models/student";
import {Absence} from "../../models/absence";
import {StudentService} from "../../services/student.service";
import {AbsenceService} from "../../services/absence.service";
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {SubjectService} from "../../services/subject.service";
import {Subject} from "../../models/subject";

@Component({
  selector: 'app-group-by-subject',
  templateUrl: './group-by-subject.component.html',
  styleUrls: ['./group-by-subject.component.css']
})
export class GroupBySubjectComponent implements OnInit {

  public subjectId: number = 4;
  public subject: Subject;
  public students: Student[];

  public datesOfAtp = ['27.02','29.02','03.05','06.02','10.02','12.02','13.02','17.02','19.02','20.02','24.02','26.02','27.02','02.02','04.03','05.03'];
  public absencesOfAtp = [
    ['2ч','2ч','','','','1ч','','','','','2ч','2ч','','','','','9ч'],
    ['2ч(ув)','2ч(ув)','2ч(ув)','','','','','','','','','','','','','','6ч'],
    ['','','','','','','','','','','','','','','','',''],
    ['','2ч','','','','','','','','','2ч','','','','','','4ч'],
    ['','','','','','','','','','','','','','','2ч','','2ч'],
    ['','2ч','','','','','','','','','','','','','','','2ч'],
    ['','','','','','2ч(ув)','2ч(ув)','','','','','','','','','','4ч'],
    ['','','','','','','','','','','','','','','','',''],
    ['','','2ч','2ч','','','','','','','','','','','','','4ч'],
    ['','','','','','','','','','','','','','','','',''],
    ['','','','','','2ч(ув)','','','','','','','2ч(ув)','','','','4ч'],
    ['','','','','','','','','','','','','','','','',''],
    ['','2ч','','','','','','','','2ч','','','','','','','2ч'],
    ['','','','','','','','','','','','','','','','',''],
    ['','','','','','','','','','','','','','2ч(ув)','2ч(ув)','2ч(ув)','6ч']
  ];


  public absences: Absence[];
  public absences2: Absence[][] = [];

  constructor(
    private studentService: StudentService,
    private absenceService: AbsenceService,
    private subjectService: SubjectService,
    public activateRoute: ActivatedRoute,
    public auth: AuthService
  ) { }

  ngOnInit() {
    this.loadAbsence(4);
    this.loadSubjectById(4);
  }

  public loadAbsence(subjectId:number){
    this.studentService.getAllStudentsByGroup(1).subscribe((value: Student[]) => {
      this.students = value;
      for (let s of this.students){
        this.absenceService.getAbsenceByStudentAndSubject(s.id, subjectId).subscribe((value: Absence[]) => {
          this.absences2[s.id] = value;
        })
      }
    })
    this.loadSubjectById(subjectId);
  }

  public loadAbsenceByStudent(studentId: number):void{
    this.absenceService.getAbsenceByStudent(studentId).subscribe((value: Absence[]) => {
      this.absences = value;
    })
  }

  public loadAbsenceBySubject(subjectId: number):void{
    this.absenceService.getAbsenceBySubject(subjectId).subscribe((value: Absence[]) => {
      this.absences = value;
      // for (var i = 0; i < this.absences.length; i++){
      //   for (var j = i+1; j < this.absences.length; j++){
      //
      //   }
      // }
    })
  }

  public loadAbsenceByStudentAndSubject(studentId: number, subjectId: number):void{
    this.absenceService.getAbsenceByStudentAndSubject(studentId, subjectId).subscribe((value: Absence[]) => {
      this.absences = value;
    })
  }

  public loadStudentByGroupId(groupId):void{
    this.studentService.getAllStudentsByGroup(groupId).subscribe((value: Student[]) => {
      this.students = value;
    })
  }

  public loadSubjectById(subjectId: number):void{
    this.subjectService.getSubjectById(subjectId).subscribe((value: Subject) => {
      this.subject = value;
    })
  }

}
