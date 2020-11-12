import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';

@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }
 emp1:Employee[]=[
 {id:1,name:'john',salary:10000,dob:"01/01/1999",permanent:'yes',department_id:1,department_name:'payroll',skill:[{id:1,name:'HTML'},{id:2,name:'CSS'}]}];
}
