import {Injectable} from "@angular/core";
import {Account} from "../models/account";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

@Injectable()
export class AuthService {

  public account: Account;
  public token: string;

  constructor(private http: HttpClient, private router: Router) {
    if (JSON.parse(localStorage.getItem('user'))&&(localStorage.getItem('token'))){
      this.account = JSON.parse(localStorage.getItem('user'));
      this.token = localStorage.getItem('token');
    }
    else {
      this.account = null;
      this.token = "";
    }
  }

  public getUser(login: String):Observable<Account>{
    return this.http.get<Account>("/api/account/login/"+login);
  }

  public getToken(user: Account):Observable<any>{
    return this.http.post("/api/token/generate-token", user);
  }

  public signIn(user: Account):void{
    this.getToken(user).subscribe(data=>{
      this.token = data.token;
      this.getUser(user.login).subscribe(data=>{
        this.account = data;
        localStorage.setItem("user", JSON.stringify(this.account));
        localStorage.setItem("token", this.token);
        if(this.account.roleByRoleId.id == 1){
          this.router.navigate(['/group/']);
        }else if(this.account.roleByRoleId.id == 2){
          this.router.navigate(['/leader']);
        }else if(this.account.roleByRoleId.id == 3){
          this.router.navigate(['/admin']);
        }
      })
    })
  }

  public logOut():void{
    localStorage.clear();
    this.account = null;
    this.token = "";
  }



}
