import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';
import { ManageflightService } from '../manageflight.service';

@Component({
  selector: 'app-manageflight',
  templateUrl: './manageflight.component.html',
  styleUrls: ['./manageflight.component.css']
})
export class ManageflightComponent implements OnInit {

  page: Number = 1;
  count: Number = 10;
  pageSizes = [5, 10, 15];

  flightCompanySearch = '';
  flightModelSearch = '';
  flightCodeSearch = '';
  searchText: string = '';
  message: any
  flightForm !: FormGroup;
  flights: any;
  saveModalBtn !: boolean;
  updateModalBtn !: boolean;
  constructor(private formbuilder: FormBuilder, private manageflightservice: ManageflightService) { };
  avlStatuses: any = ['Available', 'Not Available']
  TableHeaders: any = ['Company', 'Model', 'Code', 'Economy Seats', 'Buisness Seats', 'Status'];
  @Input() flightParam = { id: 0, flightCompany: '', flightModel: '', flightCode: '', flightEcoSeats: '', flightBuiSeats: '', flightAvlStatus: '' }




  ngOnInit(): void {
    this.getAllFLights()
    this.flightForm = this.formbuilder.group({
      id: [''],
      flightCompany: [''],
      flightModel: [''],
      flightCode: [''],
      flightEcoSeats: [''],
      flightBuiSeats: [''],
      flightAvlStatus: ['']
    });

  }

  getAllFLights() {
    this.manageflightservice.getFlights().subscribe(
      (response) => {
        console.log(response);
        this.message = response;
        this.flights = response;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  public addFlight() {
    let response = this.manageflightservice.addFlight(this.flightParam)
    response.subscribe((data) => {
      alert(data);
      this.flightForm.reset();
      let ref = document.getElementById("flightformclose");
      ref?.click();
      this.getAllFLights();
    }, err => {
      alert("Something Went Wrong");
    }
    )
  }

  public delteFlight(id: number) {
    let resp = this.manageflightservice.deleteFlight(id);
    resp.subscribe((data) => {
      this.flights = data
      console.log(data);
      this.getAllFLights();
    }, (error) => {
      console.log(error);
    });

  }
  public showSaveBtn() {

    this.flightForm.reset();
    this.saveModalBtn = true;
    this.updateModalBtn = false;

  }


  public getFlightForm(flight: any) {
    this.saveModalBtn = false;
    this.updateModalBtn = true;
    this.flightParam.id = flight.id;
    this.flightForm.controls['flightCompany'].setValue(flight.flightCompany);
    this.flightForm.controls['flightModel'].setValue(flight.flightModel);
    this.flightForm.controls['flightCode'].setValue(flight.flightCode);
    this.flightForm.controls['flightEcoSeats'].setValue(flight.flightEcoSeats);
    this.flightForm.controls['flightBuiSeats'].setValue(flight.flightBuiSeats);
    this.flightForm.controls['flightAvlStatus'].setValue(flight.flightAvlStatus);
  }

  public updateFlight() {
    let response = this.manageflightservice.updateFlight(this.flightParam, this.flightParam.id)
    response.subscribe((data) => {
      alert("Updated Successfully");
      this.flightForm.reset();
      let ref = document.getElementById("flightformclose");
      ref?.click();
      this.getAllFLights();
    }, err => {
      alert("Something Went Wrong");
    }
    )
  }

  handlePageSizeChange(event) {
    this.count = event.target.value;
  }

}



