import { Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: BookingGridComponent },
  { path: 'create', component: BookingCreateComponent },
  { path: 'edit/:id', component: BookingEditComponent },
  { path: 'view/:id', component: BookingViewComponent },
  { path: 'delete/:id', component: BookingDeleteComponent }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingRoutingModule { }
