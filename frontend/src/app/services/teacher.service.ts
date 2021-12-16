import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Teacher} from "../models/teacher";

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  constructor(private http: HttpClient) {}

  public getAllTeachers():Observable<Teacher[]>{
    return this.http.get<Teacher[]>("/api/teacher/all");
  }

}
