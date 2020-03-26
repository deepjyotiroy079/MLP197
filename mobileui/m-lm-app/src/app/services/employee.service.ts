import { Employee } from './../../../../../webui/lm-app/src/app/employee';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  listAllEmployees(): Observable<Employee[]> {
    console.log('listing all employees')
    return this.http.get<Employee[]>('http://localhost:8080/MLP197/api/employees');
  }
}
