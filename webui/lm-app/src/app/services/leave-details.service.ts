import { FormGroup } from '@angular/forms';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { leavedetails } from '../leavedetails';
import { pipeDef } from '@angular/core/src/view';

@Injectable({
  providedIn: 'root'
})
export class LeaveDetailsService {

  constructor(private http: HttpClient) { }
  getLeaveHistory(empId:number): Observable<leavedetails[]> {
    console.log('getLeaveHistory called on leavedetails.service');
    return this.http.get<leavedetails[]>('http://localhost:8080/MLP197/api/leaveDetails/leaveHistory/'+empId);
  }

  getViewPendingLeaves(mgrId:number): Observable<leavedetails[]> {
    console.log('getViewPendingLeaves called on Leavedetails.service');
    return this.http.get<leavedetails[]>('http://localhost:8080/MLP197/api/leaveDetails/viewPendingLeaves/'+mgrId);
  }
  applyLeave(leaveData) {
    return this.http.post<leavedetails>('http://localhost:8080/MLP197/api/leaveDetails/applyLeave', leaveData);
  }
  getLeaveById(leaveId:number): Observable<leavedetails> {
    console.log('getLeaveById called on Leave Details.service');
    return this.http.get<leavedetails>('http://localhost:8080/MLP197/api/leaveDetails/leave/'+leaveId);
  }
  approveLeave(leaveData) {
    console.log('approveLeave called on LeaveDetails.service');
    return this.http.post('http://localhost:8080/MLP197/api/leaveDetails/approveLeave', leaveData); 
  }
  denyLeave(leaveData) {
    console.log('denyLeave called on LeaveDetails.service');
    return this.http.post('http://localhost:8080/MLP197/api/leaveDetails/deny', leaveData);
  }
}
