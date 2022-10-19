import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { WorkSession } from './session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public getSessions(): Observable<WorkSession[]> {
    return this.http.get<WorkSession[]>(`${this.apiServerUrl}/sessions`);
  }

  public addSession(): Observable<WorkSession> {
    return this.http.post<WorkSession>(`${this.apiServerUrl}/sessions`, null);
  }

  public updateSession(name: string): Observable<WorkSession> {
    return this.http.post<WorkSession>(`${this.apiServerUrl}/sessions/update/${name}`, name);
  }

}
