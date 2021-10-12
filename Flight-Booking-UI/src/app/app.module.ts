import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgSelectModule } from '@ng-select/ng-select';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { UserService } from './_services/user.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ManageflightComponent } from './flightbooking/admin/manageflight/manageflight.component';
import { ManageflightService } from './flightbooking/admin/manageflight.service';
import { SearchFilterPipe } from './flightbooking/admin/search-filter.pipe';
import { SearchFlightPipe } from './flightbooking/admin/search-flight.pipe';
import { MultiSearchFlightPipe } from './flightbooking/admin/multi-search-flight.pipe';
import { ManagescheduleComponent } from './flightbooking/admin/manageschedule/manageschedule.component';
import { ManagescheduleService } from './flightbooking/admin/manageschedule.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    LoginComponent,
    HeaderComponent,
    ForbiddenComponent,
    ManageflightComponent,
    SearchFilterPipe,
    SearchFlightPipe,
    MultiSearchFlightPipe,
    ManagescheduleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    BrowserAnimationsModule,
    NgxPaginationModule,
    NgSelectModule
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    UserService,
    ManageflightService,
    ManagescheduleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
