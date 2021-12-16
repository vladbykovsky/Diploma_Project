import {Subject} from "./subject";
import {Student} from "./student";

export class Absence {
  id: number;
  studentByStudentId: Student;
  subjectBySubjectId: Subject;
  quantity: number;
  reason: string;
  date: string;
}
