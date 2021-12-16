import {Component, OnInit, TemplateRef} from '@angular/core';
import {Student} from "../../models/student";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {StudentService} from "../../services/student.service";
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit {

  public absencesOfAtp = ['','','','','','','','','','','','','','','2ч',''];
  public datesOfAtp = ['27.02','29.02','05.03','06.03','10.03','12.03','13.03','17.03','19.03','20.03','24.03','26.03','27.03','02.03','04.04','05.04'];

  public absencesOfBusiness = ['2ч','2ч','2ч','','','','','','','','','','',''];
  public datesOfBusiness = ['28.02','06.03','07.03','11.03','13.03','18.03','21.03','22.03','25.03','26.03','27.03','29.02','03.02','04.02'];

  public absencesOfOzi = ['2ч','2ч','','','','1ч','','','',''];
  public datesOfOzi = ['13.02','17.02','19.02','20.02','24.02','26.02','27.02','02.02','04.03','05.03'];

  public str: string = "Изм";
  public flag: number = 0;
  public student : Student;
  public modalRef: BsModalRef;

  constructor(private studentService: StudentService,
              private activateRoute: ActivatedRoute,
              public auth: AuthService,
              private modalService: BsModalService) { }

  ngOnInit(): void {
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(template: TemplateRef<any>): void{
    this.modalRef.hide();
  }

}
