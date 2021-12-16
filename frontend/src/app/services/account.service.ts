import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Account} from "../models/account";
import {Observable} from "rxjs";
import {Teacher} from "../models/teacher";

@Injectable({
  providedIn: 'root'
})
export class AccountService{
  constructor(private http: HttpClient) {}

  public getAllAccounts():Observable<Account[]>{
    return this.http.get<Account[]>("/api/account/all");
  }

  public saveUserAccount(account: Account): Observable<Account> {
    return this.http.post<Account>('/api/account', account);
  }
}
