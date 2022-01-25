import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { CreateCookComponent } from './cook/create-cook/create-cook.component';
import { UpdateCookComponent } from './cook/update-cook/update-cook.component';
import { CookTableComponent } from './cook/cook-table/cook-table.component';
import { CookService } from './services/cook/cook.service';        //'./services/cook.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { LoginFormComponent } from './Forms/login-form/login-form.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { AuthInterceptor } from './services/autentication/auth.interceptor';
import { BarmanTableComponent } from './Tables/barman-table/barman-table.component';

@NgModule({
  declarations: [
    AppComponent,
    //CreateCookComponent,
    UpdateCookComponent,
    CookTableComponent,
    LoginFormComponent,
    NavBarComponent,
    ProfilePageComponent,
    ChangePasswordFormComponent,
    BarmanTableComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass : AuthInterceptor,
      multi : true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
