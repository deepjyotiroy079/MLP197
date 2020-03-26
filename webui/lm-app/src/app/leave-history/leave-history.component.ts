import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../services/leave-details.service';
import { leavedetails } from '../leavedetails';
import { Observable } from 'rxjs';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-leave-history',
  templateUrl: './leave-history.component.html',
  styleUrls: ['./leave-history.component.css']
})
export class LeaveHistoryComponent implements OnInit {

  constructor(private leaveDetailsService: LeaveDetailsService, private route:ActivatedRoute) { }
  leaveDetails: leavedetails[];
  getLeaveHistory(empId:number): void {
    this.leaveDetailsService.getLeaveHistory(empId).subscribe(data=>this.leaveDetails=data, err=>console.log(err));
  }
  ngOnInit() {
    this.route.params.subscribe((params:Params) => {
      const empId = params['empId'];
      this.getLeaveHistory(empId);
    });

}
}
