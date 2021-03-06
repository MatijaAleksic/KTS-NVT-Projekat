import { OrderedItem } from "./ordered-item";
import { Table } from "./table";

export class Order {

    public id: number;
    public price : number;
    public waiter : any;
    public restourantTable : Table;
    public dateTime : Date;
    public food : OrderedItem[];
    


    constructor(price : number, waiter : any, restourantTable : Table){
        this.price = price;
        this.waiter = waiter;
        this.restourantTable = restourantTable;
    }
}

export class OrderBack {
    public id : number
    public price : number;
    public waiter : number;
    public restourantTable : number;
    public orderedItems : number[];


    constructor(price : number, waiter : number, restourantTable : number, orderedItems : number[], id : number){
        this.price = price;
        this.waiter = waiter;
        this.restourantTable = restourantTable;
        this.orderedItems = orderedItems;
        this.id = id;
    }
}