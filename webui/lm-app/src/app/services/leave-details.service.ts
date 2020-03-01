import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { leavedetails } from '../leavedetails';

@Injectable({
  providedIn: 'root'
})
export class LeaveDetailsService {

  constructor(private http: HttpClient) { }
  getLeaveHistory(): Observable<leavedetails[]> {
    console.log('getLeaveHistory called on leavedetails.service');
    return this.http.get<leavedetails[]>('http://localhost:8080/MLP197/api/leaveDetails/leaveHistory/6');
  }
}
