import { Component, OnInit } from '@angular/core';
import {Student} from "../../models/student";
import {StudentService} from "../../services/student.service";
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {AbsenceService} from "../../services/absence.service";
import {Absence} from "../../models/absence";
import {newArray} from "@angular/compiler/src/util";

@Component({
  selector: 'app-group-profile',
  templateUrl: './group-profile.component.html',
  styleUrls: ['./group-profile.component.css']
})
export class GroupProfileComponent implements OnInit {

  public students: Student[];
  public absences: Absence[];
  public absences2: Absence[][] = [];

  constructor(
    private studentService: StudentService,
    private absenceService: AbsenceService,
    private activateRoute: ActivatedRoute,
    private auth: AuthService
  ) { }

  ngOnInit() {
    const id = this.auth.account.studentByStudentId.id;
    this.loadStudentByGroupId(1);
    this.loadAbsence();
  }

  public loadAbsence(){
    this.studentService.getAllStudentsByGroup(1).subscribe((value: Student[]) => {
      this.students = value;
      for (let s of this.students){
        this.absenceService.getAbsenceByStudentAndSubject(s.id, 4).subscribe((value: Absence[]) => {
          this.absences2[s.id] = value;
          console.log(this.absences2[s.id].length)
        })
      }
    })

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

}
