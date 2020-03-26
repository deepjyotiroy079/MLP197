import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../services/leave-details.service';
import { leavedetails } from '../leavedetails';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-view-pending-leaves',
  templateUrl: './view-pending-leaves.component.html',
  styleUrls: ['./view-pending-leaves.component.css']
})
export class ViewPendingLeavesComponent implements OnInit {

  constructor(private leavedetailsService: LeaveDetailsService, private route: ActivatedRoute) { }
  leaveDetails: leavedetails[];
  getViewPendingLeaves(mgrId:number): void{
      this.leavedetailsService.getViewPendingLeaves(mgrId).subscribe(data=>this.leaveDetails=data,err=>console.log(err));
  }

  ngOnInit() {
    this.route.params.subscribe((params:Params) => {
      const mgrId = params['empId'];
      this.getViewPendingLeaves(mgrId);
    });
  }

}
