import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { UserService} from '../services/user.service';
import { AlertService} from '../services/alert.service';
import { AuthenticationService } from '../services/authentication.service';
import { User } from '../Model/user.model';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
 
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

userForm: FormGroup;
loading = false;
submitted = false;

constructor(private formBuilder: FormBuilder, 
            private serviceUser: UserService, 
            private alertService: AlertService,
            private authenticationService: AuthenticationService,
            private router: Router) { 
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) { 
            this.router.navigate(['/']);
        }
    }
  
ngOnInit() {
    this.initForm();
  }

initForm() {
    this.userForm = this.formBuilder.group({
    username: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
    //verificationPassword: [''],}, 
    //{validator: this.serviceUser.verifierPassword('password', 'verificationPassword')
    });
  }
/**
 * convenience getter for easy access to user form fields
 */ 
get f() { return this.userForm.controls; }
/**
 * this method consists on submitting the new user features into the data table user
 */
onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.userForm.invalid) {
      return;
    this.loading = true;}
    //const formValue = this.userForm.value;
    let role = 'ROLE_USER';
    let langue = 'français';
    let langueId = 'fr';
    let lastlogin : Date = new Date();
    let user = new User(this.userForm.value.username, this.userForm.value.password, role, this.userForm.value.email, lastlogin, langueId, langue);
    localStorage.setItem("loginVK", user.username  );
    localStorage.setItem("passwordVK", user.password );
    localStorage.setItem("roleVK", user.role);
    this.serviceUser.register(user)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/']); //navigate home
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
            /*this.userService.register(this.registerForm.value)*/
            
  }
}