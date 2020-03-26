import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ListMgrByIdComponent } from './list-mgr-by-id/list-mgr-by-id.component';
import { LeaveHistoryComponent } from './leave-history/leave-history.component';
import { ListAllComponent } from './list-all/list-all.component';
import { EmployeesService } from './services/employees.service';
import { LeaveDetailsService } from './services/leave-details.service';
import { ViewDepartmentComponent } from './view-department/view-department.component';
import { ListByIdComponent } from './list-by-id/list-by-id.component';
import { RouterModule, Routes } from '@angular/router';
import { ViewPendingLeavesComponent } from './view-pending-leaves/view-pending-leaves.component';
import { ApproveComponent } from './approve/approve.component';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ApplySuccessComponent } from './apply-success/apply-success.component';

const appRoutes :Routes = [
  { path: '', component: ListAllComponent },
  { path:'list-by-id/:empId', component: ListByIdComponent },
  { path: 'apply-leave', component: ApplyLeaveComponent },
  { path: 'apply-leave/apply-success', component: ApplySuccessComponent },
  { path: 'approve/:leaveId/:empId', component: ApproveComponent },
  { path: '**', component: PageNotFoundComponent }
]
@NgModule({
  declarations: [
    AppComponent,
    ViewDepartmentComponent,
    ListMgrByIdComponent,
    LeaveHistoryComponent,
    ListAllComponent,
    ListByIdComponent,
    ViewPendingLeavesComponent,
    ApproveComponent,
    ApplyLeaveComponent,
    PageNotFoundComponent,
    ApplySuccessComponent,
  ],
  imports: [
    BrowserModule,HttpClientModule,RouterModule.forRoot(appRoutes),ReactiveFormsModule
  ],
  providers: [EmployeesService, LeaveDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
