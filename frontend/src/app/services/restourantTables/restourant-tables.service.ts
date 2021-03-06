import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Order, OrderBack } from 'src/app/model/order';
import { Table } from 'src/app/model/table';


@Injectable({
  providedIn: 'root'
})
export class RestourantTableService {


  private currentTable: Table;

  constructor(private http: HttpClient) { }


  public getNumberOfFloors() {
    return this.http.get<number>(
      `${environment.baseUrl}/${environment.restourantTables}/numberOfFloors`);
  }


  public findTablesByFloor(floor : number) {
    return this.http.get<Table[]>(
      `${environment.baseUrl}/${environment.restourantTables}/findTablesByFloor/` + floor
    );
  }

  public getCurrentTable(){
    this.currentTable = JSON.parse(localStorage.getItem('currentTable') || '{}');
    console.log("current");
    console.log(this.currentTable);
    return this.currentTable;
  }

  public setCurrentTable(table : Table){
    this.currentTable = table;
    console.log("current set");
    console.log(this.currentTable);
    localStorage.setItem('currentTable', JSON.stringify(this.currentTable));
  }

  public getOne(id : number) {
    return this.http.get<Table>(
      `${environment.baseUrl}/${environment.restourantTables}/` + id
    );
  }

  public update(user : Table){
    return this.http.post<Table[]>(
      `${environment.baseUrl}/${environment.restourantTables}/update`, user
    ).subscribe();

  };

  public getAll() {
    return this.http.get<Table[]>(
      `${environment.baseUrl}/${environment.restourantTables}`
    );
  }

  public create(user: Table) {
    return this.http.post(
      `${environment.baseUrl}/${environment.restourantTables}`,
      user
    );
  }

  public delete(id: number) {
    return this.http.get(`${environment.baseUrl}/${environment.restourantTables}/delete/` +  id);
  }

}
