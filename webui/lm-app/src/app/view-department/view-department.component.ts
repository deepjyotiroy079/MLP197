import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Department } from '../departments'
import { EmployeesService } from '../services/employees.service';

@Component({
  selector: 'app-view-department',
  templateUrl: './view-department.component.html',
  styleUrls: ['./view-department.component.css']
})
export class ViewDepartmentComponent implements OnInit {


  constructor(private employeeService : EmployeesService) { }

  title ='Leave Management Application';
  departments : Department[];
  
  getEmpByDepartment(): void {
    this.employeeService.getEmpByDepartment().subscribe(data=>{this.departments=data; console.log(data)},err=>console.log(err));

  }

  ngOnInit(): void {
    this.getEmpByDepartment();
  }

}
