import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import {RouterModule, Routes} from "@angular/router";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {BsDropdownModule} from "ngx-bootstrap/dropdown";
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ErrorComponent } from './components/error/error.component';
import { StudentProfileComponent } from './components/student-profile/student-profile.component';
import {AuthService} from "./services/auth.service";
import {TokenStorage} from "./token.storage";
import {Interceptor} from "./app.interceptor";
import { GroupProfileComponent } from './components/group-profile/group-profile.component';
import { GroupBySubjectComponent } from './components/group-by-subject/group-by-subject.component';
import {ModalModule} from "ngx-bootstrap/modal";
import {TooltipModule} from "ngx-bootstrap/tooltip";
import { SubjectsComponent } from './components/subjects/subjects.component';
import { AdminPanelComponent } from './components/admin-panel/admin-panel.component';
import { StarostaPanelComponent } from './components/starosta-panel/starosta-panel.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'group', component: GroupBySubjectComponent},
  {path: 'student', component: StudentProfileComponent},
  {path: 'subjects', component: SubjectsComponent},
  {path: 'admin', component: AdminPanelComponent},
  {path: 'leader', component: StarostaPanelComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    HeaderComponent,
    FooterComponent,
    ErrorComponent,
    StudentProfileComponent,
    GroupProfileComponent,
    GroupBySubjectComponent,
    SubjectsComponent,
    AdminPanelComponent,
    StarostaPanelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [AuthService, TokenStorage,
    {provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
