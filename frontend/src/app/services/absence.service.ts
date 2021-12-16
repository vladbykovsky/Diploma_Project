import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../models/student";
import {Absence} from "../models/absence";

@Injectable({
  providedIn: 'root'
})
export class AbsenceService {
  constructor(private http: HttpClient) {}

  public getAbsenceByStudent(studentId: number):Observable<Absence[]>{
    return this.http.get<Absence[]>("/api/absence/studentId/" + studentId);
  }

  public getAbsenceBySubject(subjectId: number):Observable<Absence[]>{
    return this.http.get<Absence[]>("/api/absence/subjectId/" + subjectId);
  }

  public getAbsenceByStudentAndSubject(studentId: number, subjectId: number):Observable<Absence[]>{
    return this.http.get<Absence[]>("/api/absence/studentId/" + studentId + "/subjectId/" + subjectId);
  }

  public getAbsenceByDateAndSubject(date: string, subjectId: number):Observable<Absence[]>{
    return this.http.get<Absence[]>("/api/absence/date/" + date + "/subjectId/" + subjectId);
  }
}
