import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute
    
    
    ) { }

  ngOnInit(): void {
  }

}
