import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Subject} from "../models/subject";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {
  constructor(private http: HttpClient) {}

  public getAllSubjects():Observable<Subject[]>{
    return this.http.get<Subject[]>("/api/subject/all");
  }

  public getSubjectById(id: number):Observable<Subject>{
    return this.http.get<Subject>("/api/subject/"+id);
  }

}
