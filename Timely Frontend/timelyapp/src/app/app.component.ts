import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SessionService } from './session.service';
import { WorkSession} from './session';
import {MatDialog} from '@angular/material/dialog';
import { PopUpComponent } from './pop-up/pop-up.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'timelyapp';
  public sessions: WorkSession[] = [];


  public addProject(): void {
    this.sessionService.addSession().subscribe((response:WorkSession)=> {
    location.reload();
    });
  }

  constructor(private sessionService: SessionService, private dialogRef: MatDialog){}
  ngOnInit() {
    this.getSessions();
  }

  public openDialog(){
    this.dialogRef.open(PopUpComponent);
    console.log("pederu")
  }

  public getSessions(): void {
    this.sessionService.getSessions().subscribe( //depricated
      (response: WorkSession[]) => {
        this.sessions = response; 
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      } )
  }

}
 