import {Component, OnInit, TemplateRef} from '@angular/core';
import {Student} from "../../models/student";
import {StudentService} from "../../services/student.service";
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {

  public absencesOfAtp = ['2ч','2ч','','','','1ч','','','','','2ч','2ч','','','',''];
  public absencesOfBusiness = ['2ч','2ч','','','','1ч','','','','','2ч','2ч','','','',''];
  public absencesOfOzi = ['2ч','2ч','','','','1ч','','','','','2ч','2ч','','','',''];
  public str: string = "Изм";
  public flag: number = 0;
  public student : Student;
  public modalRef: BsModalRef;

  constructor(
    private studentService: StudentService,
    private activateRoute: ActivatedRoute,
    public auth: AuthService,
    private modalService: BsModalService
  ) { }

  ngOnInit() {
    this.loadStudentById(this.auth.account.studentByStudentId.id);
  }

  public loadStudentById(id:number):void {
    this.studentService.getStudentById(id).subscribe((value: Student) => {
      this.student = value;
    })
  }

  public editfunc(num: number):void{
    this.flag = num;
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(template: TemplateRef<any>): void{
    this.modalRef.hide();
  }

}
