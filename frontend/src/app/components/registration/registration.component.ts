import {Component, OnInit, TemplateRef} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {AccountService} from "../../services/account.service";
import {Subscription} from "rxjs";
import {Account} from "../../models/account";
import {StudentService} from "../../services/student.service";
import {Student} from "../../models/student";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public account: Account = new Account();
  private subscriptions: Subscription[] = [];
  public studentName: string;
  public studentSurname: string;
  public studentGroup: string;
  public studentNumber: number;
  public modalRef: BsModalRef;


  constructor(private accountService: AccountService,
              private studentService: StudentService,
              public http: HttpClient,
              private router: Router,
              private modalService: BsModalService) { }

  ngOnInit(): void {
  }

  public addAccount(template: TemplateRef<any>): void {
    this.studentService.getStudentForAccount(this.studentName, this.studentSurname, this.studentGroup)
      .subscribe((value:Student)=>{
        if ((this.studentName == value.name)&&
          (this.studentSurname == value.surname)&&
          (this.studentGroup == value.studentGroupByGroupId.title)){
          this.account.studentByStudentId.id = value.id;
          this.subscriptions.push(this.accountService.saveUserAccount(this.account).subscribe(()=>{
            this.router.navigate(['/login'])
          }));
        }
      })
    this.closeModal(template);
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(template: TemplateRef<any>): void{
    this.modalRef.hide();
  }

}
