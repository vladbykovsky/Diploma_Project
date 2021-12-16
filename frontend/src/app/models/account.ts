import {Role} from "./role";
import {Student} from "./student";

export class Account {
  id: number;
  login: string;
  password: string;
  roleByRoleId: Role;
  studentByStudentId: Student;

  constructor() {
    this.roleByRoleId = new Role();
    this.studentByStudentId = new Student();
  }

}
