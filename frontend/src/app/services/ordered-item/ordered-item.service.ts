import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserId } from 'src/app/model/user-id';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { dateDTO, dateDTO2, OrderedItem } from 'src/app/model/ordered-item';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrderedItemService {


  private currentOrderedItemSelected : OrderedItem;

  constructor(private http: HttpClient, private router: Router) { }



  public getOrderedItemsByDate(date1: Date, date2: Date) {
    console.log("date1")
    console.log(date1.toISOString().substring(0,10))
    return this.http.post<OrderedItem[]>(
      `${environment.baseUrl}/${environment.orderedItems}/getOrderedItemsByDate`, {dateTo: date1, dateFrom: date2}
    );
  }

  public setCurrentOrderedItem(orderedItem : OrderedItem){
    this.currentOrderedItemSelected = orderedItem;
  }

  public getCurrentOrderedItem(){
    return this.currentOrderedItemSelected;
  }

  public getOne(id : number) {
    return this.http.get<OrderedItem>(
      `${environment.baseUrl}/${environment.orderedItems}/` + id
    );
  }

  public update(orderedItem : OrderedItem){
    return this.http.post<UserId[]>(
      `${environment.baseUrl}/${environment.orderedItems}/update`, orderedItem
    ).subscribe();

  };

  public update1(orderedItem : OrderedItem){
    return this.http.post<UserId[]>(
      `${environment.baseUrl}/${environment.orderedItems}/update`, orderedItem
    );

  };

  public getAll() {
    return this.http.get<OrderedItem[]>(
      `${environment.baseUrl}/${environment.orderedItems}`
    );
  }

  public getAllOrderedCooks() {
    return this.http.get<OrderedItem[]>(
      `${environment.baseUrl}/${environment.orderedItems}/cooks`
    );
  }

  public getAllOrderedBarman() {
    return this.http.get<OrderedItem[]>(
      `${environment.baseUrl}/${environment.orderedItems}/barman`
    );
  }

  public getAllStaff(id : number) {
    return this.http.get<OrderedItem[]>(
      `${environment.baseUrl}/${environment.orderedItems}/staff/${id}`
    );
  }

  public create(orderedItem: OrderedItem) : Observable<OrderedItem> {
    return this.http.post<OrderedItem>(
      `${environment.baseUrl}/${environment.orderedItems}`,
      orderedItem
    );
  }

  public delete(id: number) {
    return this.http.get(`${environment.baseUrl}/${environment.orderedItems}/delete/` +  id);
  }

}
