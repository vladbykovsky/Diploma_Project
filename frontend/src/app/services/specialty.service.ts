import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Specialty} from "../models/specialty";
import {Student} from "../models/student";

@Injectable({
  providedIn: 'root'
})
export class SpecialtyService {
  constructor(private http: HttpClient) {}

  public getSpecialtyById(id: number):Observable<Specialty>{
    return this.http.get<Specialty>("/api/specialty/"+id);
  }

  public getAllSpecialty():Observable<Specialty[]>{
    return this.http.get<Specialty[]>("/api/specialty/all");
  }

}
