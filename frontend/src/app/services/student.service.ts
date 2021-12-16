import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../models/student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  constructor(private http: HttpClient) {}

  public getAllStudentsByGroup(groupId: number):Observable<Student[]>{
    return this.http.get<Student[]>("/api/student/groupId/" + groupId);
  }

  public getStudentById(id: number):Observable<Student>{
    return this.http.get<Student>("/api/student/"+id);
  }

  public getStudentForAccount(name: string, surname: string, groupTitle: string):Observable<Student>{
    return this.http.get<Student>("/api/student/name/"+name+"/surname/"+surname+"/groupTitle/"+groupTitle);
  }
}
