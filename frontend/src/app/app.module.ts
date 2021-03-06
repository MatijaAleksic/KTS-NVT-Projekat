import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { CreateCookComponent } from './cook/create-cook/create-cook.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { LoginFormComponent } from './Forms/login-form/login-form.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ChangePasswordFormComponent } from './Forms/change-password-form/change-password-form.component';
import { AuthInterceptor } from './services/autentication/auth.interceptor';
import { BarmanTableComponent } from './Tables/barman-table/barman-table.component';
import { MatTableModule } from '@angular/material/table';
import { AddNewBarmanComponent } from './Forms/add-new-barman/add-new-barman.component';
import { AddNewCookComponent } from './Forms/add-new-cook/add-new-cook.component' 
import { CookTableComponent } from './Tables/cook-table/cook-table.component';
import { MaincookTableComponent } from './Tables/maincook-table/maincook-table.component';
import { AddNewMaincookComponent } from './Forms/add-new-maincook/add-new-maincook.component';
import { WaiterTableComponent } from './Tables/waiter-table/waiter-table.component';
import { AddNewWaiterComponent } from './Forms/add-new-waiter/add-new-waiter.component';
import { AddNewManagerComponent } from './Forms/add-new-manager/add-new-manager.component';
import { ManagerTableComponent } from './Tables/manager-table/manager-table.component';
import { AdminTableComponent } from './Tables/admin-table/admin-table.component';
import { AddNewAdminComponent } from './Forms/add-new-admin/add-new-admin.component';
import { ChangeSalaryManagerComponent } from './Forms/change-salary-manager/change-salary-manager.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { StaffTableComponent } from './Tables/staff-table/staff-table.component';
import { ChangeSalaryUserComponent } from './Forms/change-salary-user/change-salary-user.component'
import {MatButtonModule} from '@angular/material/button';
import { ItemsTableComponent } from './Tables/items-table/items-table.component';
import { ChangePriceItemComponent } from './Forms/change-price-item/change-price-item.component';

import {MatBottomSheet, MatBottomSheetModule, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { MatCardModule } from '@angular/material/card';
import { NewRecipeTableComponent } from './Tables/new-recipe-table/new-recipe-table.component';
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import { MatSortModule } from '@angular/material/sort';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { FoodMenuComponent } from './food-starting-menu/food-starting-menu.component';
import { DrinkMenuComponent } from './drink-starting-menu/drink-starting-menu.component';
import { BottomSheetOverviewExampleSheet } from './item-sheet/item-sheet.component';
import { Cart } from './cart/cart.component';
import {MatInputModule} from '@angular/material/input';
import { BartenderMenuComponent } from './bartender-menu/bartender-menu.component';
import { OrderedItemSheetComponent } from './ordered-item-sheet/ordered-item-sheet.component'; 
import { BarmanRecipeTableComponent } from './Tables/barman-recipe-table/barman-recipe-table.component';
import { MaincookRecipeTableComponent } from './Tables/maincook-recipe-table/maincook-recipe-table.component';
import { ChangeItemInfoComponent } from './Forms/change-item-info/change-item-info.component';
import { AddNewDrinkComponent } from './Forms/add-new-drink/add-new-drink.component';
import { AddNewFoodComponent } from './Forms/add-new-food/add-new-food.component';
import { OrdersTableCooksComponent } from './Tables/orders-table-cooks/orders-table-cooks.component';
import { RestourantTablesComponent } from './restourant-tables/restourant-tables.component';
import {DragDropModule} from '@angular/cdk/drag-drop';
import { RestourantTablesBartenderComponent } from './restourant-tables-bartender/restourant-tables-bartender.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import { StatsComponent } from './stats/stats.component';
import { OrdersTableBarmanComponent } from './Tables/orders-table-barman/orders-table-barman.component';
import { TakenOrdersTableBarmanComponent } from './Tables/taken-orders-table-barman/taken-orders-table-barman.component';
import { TakenOrdersTableCooksComponent } from './Tables/taken-orders-table-cooks/taken-orders-table-cooks.component'; 
import { DatePipe } from '@angular/common';


@NgModule({
  declarations: [
    AppComponent,
    CookTableComponent,
    LoginFormComponent,
    NavBarComponent,
    ProfilePageComponent,
    ChangePasswordFormComponent,
    BarmanTableComponent,
    AddNewBarmanComponent,
    AddNewCookComponent,
    MaincookTableComponent,
    AddNewMaincookComponent,
    WaiterTableComponent,
    AddNewWaiterComponent,
    AddNewManagerComponent,
    ManagerTableComponent,
    AdminTableComponent,
    AddNewAdminComponent,
    ChangeSalaryManagerComponent,
    StaffTableComponent,
    ChangeSalaryUserComponent,
    ItemsTableComponent,
    ChangePriceItemComponent,
    BottomSheetOverviewExampleSheet,
    NewRecipeTableComponent,
    Cart,
    FoodMenuComponent,
    DrinkMenuComponent,
    BartenderMenuComponent,
    OrderedItemSheetComponent,
    BarmanRecipeTableComponent,
    MaincookRecipeTableComponent,
    ChangeItemInfoComponent,
    AddNewDrinkComponent,
    AddNewFoodComponent,
    OrdersTableCooksComponent,
    RestourantTablesComponent,
    RestourantTablesBartenderComponent,
    StatsComponent,
    OrdersTableBarmanComponent,
    TakenOrdersTableBarmanComponent,
    TakenOrdersTableCooksComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatTableModule,
    MatSidenavModule,
    MatButtonModule,
    MatCardModule,
    MatBottomSheetModule,
    MatIconModule,
    MatBadgeModule,
    MatSortModule,
    MatSnackBarModule,
    MatInputModule,
    DragDropModule,
    MatDatepickerModule,
    MatNativeDateModule

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass : AuthInterceptor,
      multi : true,
      
    },
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
