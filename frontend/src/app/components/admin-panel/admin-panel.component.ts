import {Component, OnInit, TemplateRef} from '@angular/core';
import {Account} from "../../models/account";
import {StudentGroup} from "../../models/studentGroup";
import {Specialty} from "../../models/specialty";
import {Subject} from "../../models/subject";
import {Teacher} from "../../models/teacher";
import {AccountService} from "../../services/account.service";
import {SpecialtyService} from "../../services/specialty.service";
import {SubjectService} from "../../services/subject.service";
import {TeacherService} from "../../services/teacher.service";
import {GroupService} from "../../services/group.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {Student} from "../../models/student";

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  public accounts: Account[];
  public groups: StudentGroup[];
  public specialties: Specialty[];
  public subjects: Subject[];
  public teachers: Teacher[];
  public modalRef: BsModalRef;

  constructor(private accountService: AccountService,
              private groupService: GroupService,
              private specialtyService: SpecialtyService,
              private subjectService: SubjectService,
              private teacherService: TeacherService,
              private modalService: BsModalService) { }

  ngOnInit(): void {
    this.loadAll();
  }

  public loadAll():void{
    this.loadAccounts();
    this.loadGroups();
    this.loadSpecialty();
    this.loadSubjects();
    this.loadTeachers();
  }

  public loadAccounts():void{
    this.accountService.getAllAccounts().subscribe((value: Account[]) => {
      this.accounts = value;
    })
  }

  public loadGroups():void{
    this.groupService.getAllGroups().subscribe((value: StudentGroup[]) => {
      this.groups = value;
    })
  }

  public loadSpecialty():void{
    this.specialtyService.getAllSpecialty().subscribe((value: Specialty[]) => {
      this.specialties = value;
    })
  }

  public loadSubjects():void{
    this.subjectService.getAllSubjects().subscribe((value: Subject[]) => {
      this.subjects = value;
    })
  }

  public loadTeachers():void{
    this.teacherService.getAllTeachers().subscribe((value: Teacher[]) => {
      this.teachers = value;
    })
  }

  public openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(template: TemplateRef<any>): void{
    this.modalRef.hide();
  }

}
