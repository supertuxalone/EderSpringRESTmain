import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeadrComponent } from './headr.component';
import { MenuModule } from '../menu/menu.module';

@NgModule({
  declarations: [
    HeadrComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MenuModule
  ],
  exports:[
    HeadrComponent
  ]
})
export class HeadrModule { }
