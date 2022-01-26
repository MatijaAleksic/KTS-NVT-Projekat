
import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { BarmanService } from 'src/app/services/barman/barman-service.service';

@Component({
  selector: 'app-barman-table',
  templateUrl: './barman-table.component.html',
  styleUrls: ['./barman-table.component.css']
})
export class BarmanTableComponent implements OnInit {

  barmans: User[];
  displayedColumns: string[] = ["id", "firstName", "lastName", "username", "dateOfBirth", "salary", "delete"];

  constructor(
    private router: Router,
    private barmanService: BarmanService
  ) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.barmanService.getAll().subscribe(
      res => {
        this.barmans = res;

        const datePipe = new DatePipe('en-US');
        this.barmans.forEach( (element) => {
          element.dateOfBirth = datePipe.transform(element.dateOfBirth, 'dd/MM/yyyy') || "";
      });
        console.log(this.barmans);
      },
      () => {
        alert("SHIT!")
      }
    );
  }

  addNew() {
    this.router.navigate([`add-barman`]);
  }

  deleteBarman(id : number){
    this.barmanService.delete(id);
    this.getAll();
  }

  alertuj(text : string){
    alert(text);
  }

}
