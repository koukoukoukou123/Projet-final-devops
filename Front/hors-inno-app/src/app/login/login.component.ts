import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthenticationService } from '../services/authentication.service';
import { AlertService } from '../services/alert.service';
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
/**
 *The login component contains all of the logic for validating...
 *...the login form and handling form submission.
 */
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
 
/**
 *The constructor() method checks if the user is already logged in by checking....
 *...authenticationService.currentUserValue and redirects to the home page if they are
 */
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService
    ) {
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) { 
            this.router.navigate(['/']);
        }
    }
/**
  *The ngOnInit() method :
  * I) creates a new FormGroup by calling this.formBuilder.group() and assigns it to the this.loginForm property.
  * => The parameters passed to the FormBuilder tell it to create two form controls : username and password,...
  * these 2 form controls are both initialised with empty strings ('') as values and set to required with the Validators.required Angular validator.
  * II) sets the this.returnUrl property to the value passed in the url querystring,...
  * ...or (||) defaults to the home page ('/') if there isn't a value in the querystring. 
  * =>The return url property allows you to redirect the user back to the original page they requested before logging in.
  */
  ngOnInit() {
    // I)
    this.loginForm = this.formBuilder.group({
         username: ['', Validators.required],
         password: ['', Validators.required]
        });
    // II)
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
/**
  * The f() getter is a convenience property to enable shorthand access to the login form controls ...
  * ...via this.f in the login component and f in the login component template that we'll create in the next step.
  */
  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }
 
onSubmit() {
  //onSubmit() sets the this.submitted property to true to indicate that an attempt has been made to submit the form,...
  //...this property is used in the login component template to display validation errors only after the first submission has been attempted.
  this.submitted = true;

  //then onSubmit() method checks if the form is valid by checking this.loginForm.invalid...
  //..and prevents submission if it is invalid.
  // => therefore: stop here if form is invalid
  if (this.loginForm.invalid) {
    return;
  }
  // but if the form is valid (which means that this.loginForm.invalid === false), we do the 1) and 2) :
  // 1)  onSubmit() method sets the this.loading property to true before submitting the user credentials via the authentication service,...
  //...this property (this.loading) is used in the login component template to display a loading spinner to the user and disable the login button.
  this.loading = true;
  // 2)  onSubmit() method authenticates the user by calling the this.authenticationService.login() method with the username and password as parameters. 
  this.authenticationService.login(this.f.username.value, this.f.password.value)
                            .pipe(first())
  // 2.a) The authentication service returns an Observable that we .subscribe() to for the results of the authentication.
                            .subscribe(
  // 2.a.1) In case of success: the user is redirected to the returnUrl by calling this.router.navigate([this.returnUrl]);
                            data => {
                                this.router.navigate([this.returnUrl]);
                            },
  // 2.a.2) In case of fail: the error message is stored in the this.error property to be displayed by the template...
  // ...and the this.loading property is reset back to false
                            error => {
                                this.alertService.error(error);
                                this.loading = false;
                            });

  // The call to .pipe(first()) unsubscribes from the observable immediately after the first value is emitted.
  }
}



