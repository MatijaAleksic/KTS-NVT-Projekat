import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './Forms/login-form/login-form.component';

import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser'
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { BarmanTableComponent } from './Tables/barman-table/barman-table.component';
import { AddNewBarmanComponent } from './Forms/add-new-barman/add-new-barman.component';
import { CookTableComponent } from './Tables/cook-table/cook-table.component';
import { AddNewCookComponent } from './Forms/add-new-cook/add-new-cook.component';
import { MaincookTableComponent } from './Tables/maincook-table/maincook-table.component';
import { AddNewMaincookComponent } from './Forms/add-new-maincook/add-new-maincook.component';
import { WaiterTableComponent } from './Tables/waiter-table/waiter-table.component';
import { AddNewWaiterComponent } from './Forms/add-new-waiter/add-new-waiter.component';
import { ManagerTableComponent } from './Tables/manager-table/manager-table.component';
import { AddNewManagerComponent } from './Forms/add-new-manager/add-new-manager.component';
import { AdminTableComponent } from './Tables/admin-table/admin-table.component';
import { AddNewAdminComponent } from './Forms/add-new-admin/add-new-admin.component';
import { ChangeSalaryManagerComponent } from './Forms/change-salary-manager/change-salary-manager.component';
import { StaffTableComponent } from './Tables/staff-table/staff-table.component';
import { ChangeSalaryUserComponent } from './Forms/change-salary-user/change-salary-user.component';
import { ItemsTableComponent } from './Tables/items-table/items-table.component';
import { ChangePriceItemComponent } from './Forms/change-price-item/change-price-item.component';
import { NewRecipeTableComponent } from './Tables/new-recipe-table/new-recipe-table.component';
import { FoodMenuComponent } from './food-starting-menu/food-starting-menu.component';
import { DrinkMenuComponent } from './drink-starting-menu/drink-starting-menu.component';
import { BarmanRecipeTableComponent } from './Tables/barman-recipe-table/barman-recipe-table.component';
import { MaincookRecipeTableComponent } from './Tables/maincook-recipe-table/maincook-recipe-table.component';
import { BartenderMenuComponent } from './bartender-menu/bartender-menu.component';

import { ChangeItemInfoComponent } from './Forms/change-item-info/change-item-info.component';
import { AddNewDrinkComponent } from './Forms/add-new-drink/add-new-drink.component';
import { AddNewFoodComponent } from './Forms/add-new-food/add-new-food.component';
import { OrdersTableCooksComponent } from './Tables/orders-table-cooks/orders-table-cooks.component';
import { RestourantTablesComponent } from './restourant-tables/restourant-tables.component';
import { RestourantTablesBartenderComponent } from './restourant-tables-bartender/restourant-tables-bartender.component';
import { StatsComponent } from './stats/stats.component';
import { OrdersTableBarmanComponent } from './Tables/orders-table-barman/orders-table-barman.component';
import { TakenOrdersTableBarmanComponent } from './Tables/taken-orders-table-barman/taken-orders-table-barman.component';
import { TakenOrdersTableCooksComponent } from './Tables/taken-orders-table-cooks/taken-orders-table-cooks.component';
import { NotificationsComponent } from './notifications/notifications.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login', 
    pathMatch: 'full'
  },

  {
    path: 'login',
    component: LoginFormComponent,
  },

  {
    path: 'stats',
    component: StatsComponent,
  },


  {
    path: 'restourant-menu-bartender',
    component: RestourantTablesBartenderComponent,
  },
  {
    path: 'restourant-menu-manager',
    component: RestourantTablesComponent,
  },


  {
    path: 'bartender-menu',
    component: BartenderMenuComponent,
  },
  
  { 
    path: 'food-menu', component: FoodMenuComponent
  },

  { 
    path: 'drink-menu', component: DrinkMenuComponent
  },

  {
    path: 'navbar',
    component: NavBarComponent,
  },

  {
    path: 'profile',
    component: ProfilePageComponent,
  },

  {
    path: 'change-password',
    component: ChangePasswordFormComponent,
  },

  {
    path: 'barman-table',
    component: BarmanTableComponent,
  },

  {
    path: 'add-barman',
    component: AddNewBarmanComponent,
  },

  {
    path: 'cook-table',
    component: CookTableComponent,
  },

  {
    path: 'add-cook',
    component: AddNewCookComponent,
  },

  {
    path: 'main-cook-table',
    component: MaincookTableComponent,
  },

  {
    path: 'add-main-cook',
    component: AddNewMaincookComponent,
  },

  {
    path: 'waiter-table',
    component: WaiterTableComponent,
  },

  {
    path: 'add-waiter',
    component: AddNewWaiterComponent,
  },

  {
    path: 'manager-table',
    component: ManagerTableComponent,
  },

  {
    path: 'add-manager',
    component: AddNewManagerComponent,
  },

  {
    path: 'admin-table',
    component: AdminTableComponent,
  },

  {
    path: 'add-admin',
    component: AddNewAdminComponent,
  },

  {
    path: 'edit-salary',
    component: ChangeSalaryManagerComponent,
  },

  {
    path: 'staff-table',
    component: StaffTableComponent,
  },

  {
    path: 'edit-salary-user',
    component: ChangeSalaryUserComponent,
  },

  {
    path: 'items-table',
    component: ItemsTableComponent,
  },

  {
    path: 'edit-item-price',
    component: ChangePriceItemComponent,
  },

  {
    path: 'new-recipe-table',
    component: NewRecipeTableComponent,
  },

  {
    path: 'barman-recipe-table',
    component: BarmanRecipeTableComponent,
  },

  {
    path: 'maincook-recipe-table',
    component: MaincookRecipeTableComponent,
  },

  {
    path: 'edit-item-info',
    component: ChangeItemInfoComponent,
  },

  {
    path: 'add-drink',
    component: AddNewDrinkComponent,
  },

  {
    path: 'add-food',
    component: AddNewFoodComponent,
  },

  {
    path: 'order-table-cooks',
    component: OrdersTableCooksComponent,
  },

  {
    path: 'order-table-barman',
    component: OrdersTableBarmanComponent,
  },

  {
    path: 'taken-orders-table-barman',
    component: TakenOrdersTableBarmanComponent,
  },

  {
    path: 'taken-orders-table-cooks',
    component: TakenOrdersTableCooksComponent,
  },

  {
    path: 'notifications',
    component: NotificationsComponent,
  },

];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes) ],
  declarations: [],
  providers: [],
  // bootstrap: [AppComponent]
  exports: [RouterModule,BrowserModule ]
  
})

export class AppRoutingModule { }
