import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeesService } from '../services/employees.service';

@Component({
  selector: 'app-list-mgr-by-id',
  templateUrl: './list-mgr-by-id.component.html',
  styleUrls: ['./list-mgr-by-id.component.css'],
})
export class ListMgrByIdComponent implements OnInit {

  constructor(private employeeService: EmployeesService) { }
  title = 'View Manager details';
  employees: Employee;
  getManager(): void {
    this.employeeService.getManager().subscribe(data=>this.employees=data,err=>console.log(err));
  }
  
  ngOnInit(): void {
    this.getManager();
  }

}
