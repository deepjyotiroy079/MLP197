import { HttpClient } from '@angular/common/http';
import { Http } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../services/leave-details.service';
import { ActivatedRoute, Router, Params, Route } from '@angular/router';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {

  empForm: FormGroup;
  typeOfLeaves:any = ['EARNED_LEAVE', 'MATERNITY_LEAVE', 'PATERNITY_LEAVE'];
  constructor(private leaveDetailsService: LeaveDetailsService, private route:ActivatedRoute, private http:HttpClient, private router: Router) {}
  ngOnInit(): void {  
    this.empForm = new FormGroup({
      empId: new FormControl(),
      leaveStartDate: new FormControl(),
      leaveEndDate: new FormControl(),
      leaveNoOfDays: new FormControl(),
      leaveType: new FormControl(),
      leaveReason: new FormControl()
    });
    this.route.params.subscribe((params:Params) => {
      const empIdValue = params['empId'];
      const leaveStartDateValue = params['leaveStartDate'];
      const leaveEndDateValue = params['leaveEndDate'];
      const leaveNoOfDaysValue = params['leaveNoOfDays'];
      const leaveTypeValue = params['leaveType'];
      const leaveReasonValue = params['leaveReason'];
      this.empForm.patchValue({
        empId:empIdValue,
        leaveStartDate:leaveStartDateValue,
        leaveEndDate:leaveEndDateValue,
        leaveNoOfDays:leaveNoOfDaysValue,
        leaveType:leaveTypeValue,
        leaveReason:leaveReasonValue
      });
    });
  }
  onSubmit() {
    console.log(this.empForm.value);
    this.leaveDetailsService.applyLeave(this.empForm.value).subscribe(data=>{
      console.log(data);
    }, err=>{
      console.log(err);
    });
    this.router.navigate(['apply-leave/apply-success']).then(nav=>{
      console.log(nav);
    }, err=> {
      console.log(err);
    });
  }  
  fnCancel() {
    this.router.navigate(['']);
  }
}
