import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeesService } from '../services/employees.service';

@Component({
  selector: 'app-list-by-id',
  templateUrl: './list-by-id.component.html',
  styleUrls: ['./list-by-id.component.css']
})
export class ListByIdComponent implements OnInit {
  constructor(private employeeService: EmployeesService) { }

  title = 'Leave Management Application';
  employees: Employee;

  getEmpById():void {
    this.employeeService.getEmpById().subscribe(data=>this.employees=data, err=>console.log(err));
  }

  ngOnInit(): void {
    this.getEmpById();
  }
}


