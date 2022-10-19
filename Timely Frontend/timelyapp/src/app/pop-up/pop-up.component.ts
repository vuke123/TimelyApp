import { Component, OnInit } from '@angular/core';
import { WorkSession } from '../session';
import { SessionService } from '../session.service';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent implements OnInit {

  constructor(private sessionService: SessionService) { }

  ngOnInit(): void {
  }

  public exit() {
    location.reload();
  }

  public updateProject(name: string): void {
    this.sessionService.updateSession(name).subscribe((response: WorkSession) => {
      location.reload();
    });
    
  }


}
