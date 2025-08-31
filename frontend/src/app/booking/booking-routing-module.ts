import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingListComponent } from './booking-list';
import { BookingFormComponent } from './booking-form';

const routes: Routes = [
  { path: 'bookings', component: BookingListComponent },
  { path: 'bookings/add', component: BookingFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingRoutingModule {}
