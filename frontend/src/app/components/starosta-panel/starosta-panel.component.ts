import {Component, OnInit, TemplateRef} from '@angular/core';
import {Student} from "../../models/student";
import {StudentService} from "../../services/student.service";
import {AuthService} from "../../services/auth.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {Subject} from "../../models/subject";
import {SubjectService} from "../../services/subject.service";

@Component({
  selector: 'app-starosta-panel',
  templateUrl: './starosta-panel.component.html',
  styleUrls: ['./starosta-panel.component.css']
})
export class StarostaPanelComponent implements OnInit {


  public students: Student[];
  public subject: Subject;
  public editStudent: Student = new Student();
  public datesOfAtp = ['27.02','29.02','03.05','06.02','10.02','12.02','13.02','17.02','19.02','20.02','24.02','26.02','27.02','02.02','04.03','05.03'];
  public absencesOfAtp = [
    ['2ч','2ч','','','','1ч','','','','','2ч','2ч','','','',''],
    ['2ч(ув)','2ч(ув)','2ч(ув)','','','','','','','','','','','','',''],
    ['','','','','','','','','','','','','','','',''],
    ['','2ч','','','','','','','','','2ч','','','','',''],
    ['','','','','','','','','','','','','','','2ч',''],
    ['','2ч','','','','','','','','','','','','','',''],
    ['','','','','','2ч(ув)','2ч(ув)','','','','','','','','',''],
    ['','','','','','','','','','','','','','','',''],
    ['','','2ч','2ч','','','','','','','','','','','',''],
    ['','','','','','','','','','','','','','','',''],
    ['','','','','','2ч(ув)','','','','','','','2ч(ув)','','',''],
    ['','','','','','','','','','','','','','','',''],
    ['','2ч','','','','','','','','2ч','','','','','',''],
    ['','','','','','','','','','','','','','','',''],
    ['','','','','','','','','','','','','','2ч(ув)','2ч(ув)','2ч(ув)']
  ];
  public absences: number = [15][16];
  public modalRef: BsModalRef;

  constructor(public studentService: StudentService,
              public auth: AuthService,
              private subjectService: SubjectService,
              private modalService: BsModalService) { }

  ngOnInit(): void {
    this.loadStudentByGroupId(1);
    this.loadSubjectById(4);
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

  public openModal(template: TemplateRef<any>, student: Student): void {
    if(student){
      this.editStudent = student;
    }

    this.modalRef = this.modalService.show(template);
  }

  public closeModal(template: TemplateRef<any>): void{
    this.modalRef.hide();
  }


}
