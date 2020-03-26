import { ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeesService } from '../services/employees.service';
// import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-list-mgr-by-id',
  templateUrl: './list-mgr-by-id.component.html',
  styleUrls: ['./list-mgr-by-id.component.css'],
})
export class ListMgrByIdComponent implements OnInit {

  constructor(private employeeService: EmployeesService, private route: ActivatedRoute) { }
  employees: Employee;
  getManager(empId:number): void {
    this.employeeService.getManager(empId).subscribe(data=>this.employees=data,err=>console.log(err));
  }
  
  ngOnInit(): void {
    this.route.params.subscribe((params:Params) => {
      const empId = params['empId'];
      this.getManager(empId);
    });
  }

}
