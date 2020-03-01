import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListMgrByIdComponent } from './list-mgr-by-id/list-mgr-by-id.component';
import { LeaveHistoryComponent } from './leave-history/leave-history.component';
import { ListAllComponent } from './list-all/list-all.component';
import { EmployeesService } from './services/employees.service';
import { LeaveDetailsService } from './services/leave-details.service';
import { ViewDepartmentComponent } from './view-department/view-department.component';
import { ListByIdComponent } from './list-by-id/list-by-id.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewDepartmentComponent,
    ListMgrByIdComponent,
    LeaveHistoryComponent,
    ListAllComponent,
    ListByIdComponent
  ],
  imports: [
    BrowserModule,HttpClientModule
  ],
  providers: [EmployeesService, LeaveDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
