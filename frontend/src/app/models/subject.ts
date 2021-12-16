import {Teacher} from "./teacher";

export class Subject {
  id: number;
  title: string;
  fullTitle: string;
  teacherByTeacherId: Teacher;
}
