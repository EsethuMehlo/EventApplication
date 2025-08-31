import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';

import { BookingRoutingModule } from './booking-routing.module';
import { BookingListComponent } from './booking-list';
import { BookingFormComponent } from './booking-form';

@NgModule({
  declarations: [
    BookingListComponent,
    BookingFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatTableModule,
    MatButtonModule,
    BookingRoutingModule
  ]
})
export class BookingModule {}
