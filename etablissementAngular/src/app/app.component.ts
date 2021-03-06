import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  
  constructor(private router: Router) {
  }

  get user() : string | null {
    return sessionStorage.getItem('login');
  }

  public logout() {
    sessionStorage.clear();
    this.user;
    this.router.navigate(['/login']);
  }
}
