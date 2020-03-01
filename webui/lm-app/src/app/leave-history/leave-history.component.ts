import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../services/leave-details.service';
import { leavedetails } from '../leavedetails';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-leave-history',
  templateUrl: './leave-history.component.html',
  styleUrls: ['./leave-history.component.css']
})
export class LeaveHistoryComponent implements OnInit {

  constructor(private leaveDetailsService: LeaveDetailsService) { }
  leaveDetails: leavedetails[];
  ngOnInit() {
    this.getLeaveHistory();
  }
  getLeaveHistory(): void {
    this.leaveDetailsService.getLeaveHistory().subscribe(data=>this.leaveDetails=data, err=>console.log(err));
  }

}
