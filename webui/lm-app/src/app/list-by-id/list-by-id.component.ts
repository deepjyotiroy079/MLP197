import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeesService } from '../services/employees.service';
import { ActivatedRoute, Params } from '@angular/router';
@Component({
  selector: 'app-list-by-id',
  templateUrl: './list-by-id.component.html',
  styleUrls: ['./list-by-id.component.css'],
  providers:[ EmployeesService ]
})
export class ListByIdComponent implements OnInit {
  constructor(private employeeService:EmployeesService,private route:ActivatedRoute) { }

  title = 'Leave Management Application';
  employees: Employee;

  getEmpById(empId:number):void {
    this.employeeService.getEmpById(empId).subscribe(data=>this.employees=data, err=>console.log(err));
  }
  
  ngOnInit() {
    this.route.params.subscribe((params:Params) =>{
      const empId = params["empId"];
      this.getEmpById(empId);
    });
    
  }
}


