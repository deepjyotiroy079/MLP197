import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { Department } from '../departments';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  constructor(private http: HttpClient) { }
  getEmployees(): Observable<Employee[]> {
    console.log('getEmployees called on employee.service');
    return this.http.get<Employee[]>('http://localhost:8080/MLP197/api/employees');

  }
  getManager(): Observable<Employee> {
    console.log('getManager called on employee.service');
    return this.http.get<Employee>('http://localhost:8080/MLP197/api/employees/manager/2');
}
getEmpByDepartment(): Observable<Department[]> {
  console.log('getEmpByDepartment called on employee.service');
  return this.http.get<Department[]>('http://localhost:8080/MLP197/api/employees/listDepartments');
}
  getEmpById(): Observable<Employee> {
    console.log('getEmployees called on employee.service');
    return this.http.get<Employee>('http://localhost:8080/MLP197/api/employees/listemployee/2');
  }
}
