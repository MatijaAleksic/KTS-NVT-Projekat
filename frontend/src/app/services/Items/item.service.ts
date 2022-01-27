import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/index";
import { ApiResponse } from 'src/app/model/api.response';
import { Item } from 'src/app/model/item.model';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = 'http://localhost:8080/items/';

  

  getItems() : Observable<Item[]> {
    const items = this.http.get<Item[]>(this.baseUrl);

    return items
  }

  getCategories() : Observable<string[]>{
    const categories = this.http.get<string[]>(this.baseUrl + "getSubcategories");

    return categories
  }

  findBySubcategory(subcategory: string) : Observable<Item[]>{
    const items = this.http.post<Item[]>(this.baseUrl + "findBySubcategory", subcategory);

    return items
  }

  getItemById(id: number): Observable<Item> {
    return this.http.get<Item>(this.baseUrl + id);
  }

  createItem(item: Item): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, item);
  }

  updateItem(item: Item): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl, item);
  }

  deleteItem(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
}