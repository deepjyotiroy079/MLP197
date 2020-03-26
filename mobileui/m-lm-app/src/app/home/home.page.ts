import { EmployeeService } from './../services/employee.service';
import { Employee } from './../../../../../webui/lm-app/src/app/employee';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit{

  employees: Employee[];
  constructor(private employeeService: EmployeeService) {}
  ngOnInit() {
    this.getAllEmployees();
  }
  getAllEmployees(): void {
    this.employeeService.listAllEmployees().subscribe(data=>this.employees = data, err=>console.log(err));
  }
}
