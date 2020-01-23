import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TokenInterceptorService } from './service/security/token-interceptor.service';
import { AuthenticationService } from './service/security/authentication-service.service';
import { CanActivateAuthGuard } from './service/security/can-activate-auth.guard';
import { JwtUtilsService } from './service/security/jwt-utils.service';
import { MainPageComponent } from './main-page/main-page.component';
import { DishCategoryService } from './dish-category.service';
import { DishService } from './dish.service';
import { EditAddFormComponent } from './edit-add-form/edit-add-form.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainPageComponent,
    EditAddFormComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    AuthenticationService,
    CanActivateAuthGuard,
    JwtUtilsService,
    DishCategoryService,
    DishService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
