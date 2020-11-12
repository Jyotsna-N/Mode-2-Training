import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { QuantityIncrementComponent } from './quantity-increment/quantity-increment.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';

const routes: Routes = [
  {path:'edit-emp',component:EditEmpComponent},
  {path:'view-emp',component:ViewEmpComponent},
  {path:'quantity-increment',component:QuantityIncrementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
