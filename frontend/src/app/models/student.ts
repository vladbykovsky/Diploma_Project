import {StudentGroup} from "./studentGroup";

export class Student {
  id: number;
  name: string;
  surname: string;
  middleName: string;
  gender: string;
  birthday: string;
  city: string;
  telephone: string;
  mail: string;
  studentGroupByGroupId: StudentGroup;

  static cloneBase(student: Student): Student {
    const clonedStudent: Student = new Student();
    clonedStudent.id = student.id;
    clonedStudent.name = student.name;
    clonedStudent.surname = student.surname;
    clonedStudent.middleName = student.middleName;
    clonedStudent.gender = student.gender;
    clonedStudent.birthday = student.birthday;
    clonedStudent.city = student.city;
    clonedStudent.telephone = student.telephone;
    clonedStudent.mail = student.mail;
    clonedStudent.studentGroupByGroupId = student.studentGroupByGroupId;
    return clonedStudent;
  }

}
