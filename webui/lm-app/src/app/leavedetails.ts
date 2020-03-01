export class leavedetails {
  leaveId: number;
  leaveStartDate: Date;
  leaveEndDate: Date;
  leaveNoOfDays: number;
  leaveType: string;
  leaveReason: string;
  leaveStatus: string;
  leaveAppliedOn: Date;
  leaveComment: string;
  empId: number;
}
// enum leaveType { EARNED_LEAVE, PATERNITY_LEAVE, MATERNITY_LEAVE };
// enum leaveStatus { APPROVED, DENIED ,PENDING};