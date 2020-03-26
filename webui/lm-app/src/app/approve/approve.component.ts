import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../services/leave-details.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { leavedetails } from '../leavedetails';
import { FormGroup, FormControl } from '@angular/forms';
import { ApproveLeave } from '../approveLeave';
import { EmployeesService } from '../services/employees.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-approve',
  templateUrl: './approve.component.html',
  styleUrls: ['./approve.component.css']
})
export class ApproveComponent implements OnInit {
  constructor(private leaveDetailsService: LeaveDetailsService, private employeeService: EmployeesService, private route: ActivatedRoute, private router: Router) {  }
  leavedetailsData: leavedetails;
  employee: Employee;
  approveForm: FormGroup;
  ngOnInit(): void {
    this.approveForm = new FormGroup({
      comments: new FormControl()
    });
    this.route.params.subscribe((param: Params)=>{
      const leaveId = param['leaveId']; // leave Id
      const empId = param['empId']; // emp ID
      // const comments = param['comments'];
      this.leaveDetailsService.getLeaveById(leaveId).subscribe(data => {
        this.leavedetailsData = data;
      });
      this.employeeService.getEmpById(empId).subscribe(data => {
        this.employee = data;
      });
    });
    
  }
  fnApprove() { 
    const leaveApprovedData = {
      leaveId: this.leavedetailsData.leaveId,
      empId: this.leavedetailsData.empId
    };
    // console.log(JSON.stringify(leaveApprovedData));
    this.leaveDetailsService.approveLeave(leaveApprovedData).subscribe(data => {
      console.log(data);
    });
    this.router.navigate(['']);
  }
  fnCancel() {
    this.router.navigate(['']);
  }
  fnDeny() { 
    this.leaveDetailsService.denyLeave(this.leavedetailsData).subscribe(data => {
        console.log(data);
      });
    this.router.navigate(['']);
  }
  // approveLeave(): void {
  //   this.leaveDetailsService.approveLeave(this.leaveApprovedData);
  //   console.log("Approved");
  // }
//   leaveDetails: leavedetails;
//   empForm : FormGroup;
//   constructor(private leaveDetailsService: LeaveDetailsService, private route:ActivatedRoute ,private router : Router ) { }
//    getViewApprove(): void {
//     this.leaveDetailsService.getViewApprove().subscribe(data=>this.leaveDetails=data, err=>console.log(err));
//   }
//   ngOnInit() {
//     this.empForm = new FormGroup({
//       empId : new FormControl(),
//       leaveId : new FormControl()
//     });

//     this.route.params.subscribe((params:Params) => {
//       const empId = params['empId'];
//       const leaveId = params['leaveId'];
//       this.getViewApprove();
//       this.empForm.patchValue({
//         empId:this.leaveDetails.empId,
//         leaveId:this.leaveDetails.leaveId,
//       })
//     });

// }
  // onSubmit() {
  //   this.approveLeave(); 
  //   this.router.navigate(['']);
  // }
}
