import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Teacher} from "../models/teacher";
import {StudentGroup} from "../models/studentGroup";

@Injectable({
  providedIn: 'root'
})
export class GroupService {
  constructor(private http: HttpClient) {}

  public getAllGroups():Observable<StudentGroup[]>{
    return this.http.get<StudentGroup[]>("/api/group/all");
  }

}
