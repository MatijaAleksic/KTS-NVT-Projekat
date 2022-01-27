import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CookTableComponent } from './cook/cook-table/cook-table.component';
import { CreateCookComponent } from './cook/create-cook/create-cook.component';
import { UpdateCookComponent } from './cook/update-cook/update-cook.component';
import { StartingMenuComponent } from './starting-menu/starting-menu.component';
const routes: Routes = [
  { path: '', redirectTo: 'cook', pathMatch: 'full' },
  { path: 'add', component: CreateCookComponent },
  { path: 'employees', component: CookTableComponent },
  { path: 'update/:id', component: UpdateCookComponent },
  { path: 'menu', component: StartingMenuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
