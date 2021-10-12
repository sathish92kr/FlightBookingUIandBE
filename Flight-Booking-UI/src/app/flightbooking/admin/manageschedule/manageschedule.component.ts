import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';
import { ManageflightService } from '../manageflight.service';
import { ManagescheduleService } from '../manageschedule.service';

@Component({
  selector: 'app-manageschedule',
  templateUrl: './manageschedule.component.html',
  styleUrls: ['./manageschedule.component.css']
})
export class ManagescheduleComponent implements OnInit {


  flightCompanySearch = '';
  flightModelSearch = '';
  flightCodeSearch = '';

  flightArr:any;

  mySelect = '5';
  selectedValue: any;

  flightSchParam1 = { flight: '' }
  isddeditMode=false;
  flightList;
  flightParam: any;
  isEditMode: boolean = false;
  searchText: string = '';
  message: any
  flightSchForm?: FormGroup;
  flightschedule?: any;
  saveModalBtn !: boolean;
  updateModalBtn !: boolean;
  avlStatuses: any = ['Available', 'Not Available']
  TableHeaders: any = ['Flight Name', 'Departure', 'Arrival',
    'From Date', 'To Date', 'From Time',
    'To Time', 'Flight Model', 'Price Economy', 'Price Buisness'];
  @Input() flightSchParam = {
    id: 0, flightName: '', flightDepLoc: '', flightArrLoc: '',
    flightDepDate: '', flightArrDate: '', flightDepTime: '', flightArrTime: '',
    flight: { id: 0, flightCompany: '', flightModel: '', flightCode: '', flightEcoSeats: '', flightBuiSeats: '', flightAvlStatus: '' },
    flightfare: { id: 0, flightEcoFare: '', flightBuiFare: '' }
  }


  constructor(private formbuilder: FormBuilder, private managescheduleservice: ManagescheduleService, private manageflightservice: ManageflightService) { };

  ngOnInit(): void {
    this.getAllFLightSchedule()
    this.getFlightsMethod()
    this.flightSchForm = this.formbuilder.group({
      id: [''],
      flightName: [''],
      flightDepLoc: [''],
      flightArrLoc: [''],
      flightDepDate: [''],
      flightArrDate: [''],
      flightDepTime: [''],
      flightArrTime: [''],
      flight: this.formbuilder.group({
        id: [''],
        flightCompany: [''], flightModel: [''],
        flightCode: [''], flightEcoSeats: [''],
        flightBuiSeats: [''], flightAvlStatus: [''],

      }),
      flightfare: this.formbuilder.group({
        flightEcoFare: [''],
        flightBuiFare: ['']
      })
    });

  }
  getAllFLightSchedule() {

    this.managescheduleservice.getFlightSchedule().subscribe(
      (response) => {
        console.log(response);
        this.message = response;
        this.flightschedule = response;
        this.flightschedule.forEach(element => {
          element['isEditMode'] = false
        });
      },
      (error) => {
        console.log(error);
      }
    );


  }

  public addFlightSchedule() {
    let response = this.managescheduleservice.addFlightSchedule(this.flightSchParam)
    response.subscribe((data) => {
      alert(data);
      this.getAllFLightSchedule();
      this.flightSchForm.reset();
    }, err => {
      alert("Something Went Wrong");
    }
    )
  }

  changeFlight(e) {
    console.log(e)
    // this.flightSchForm.controls['flight.flightCompany'].setValue(e.flightCompany);
    this.flightSchParam.flight.flightCompany = e?.flightCompany
    this.flightSchParam.flight.flightModel = e?.flightModel
    this.flightSchParam.flight.flightCode = e?.flightCode
    this.flightSchParam.flight.flightAvlStatus = e?.flightAvlStatus
    this.flightSchParam.flight.flightEcoSeats = e?.flightEcoSeats
    this.flightSchParam.flight.flightBuiSeats = e?.flightBuiSeats
  }

  public getFlightsMethod() {
    let response = this.manageflightservice.getFlights()
    response.subscribe((data) => {
      this.flightList = data as string[];
    }, err => {
      alert("Something Went Wrong");
    }
    )
  }


  public delteSchedule(id: number) {
    let resp = this.managescheduleservice.deleteSchedule(id);
    resp.subscribe((data) => {
      this.flightschedule = data
      console.log(data);
      this.getAllFLightSchedule();
      alert("Deleted Successfully");
    }, (error) => {
      console.log(error);
      alert(error);
    });

  }

  public updateSchedule(flightsch,i) {

    this.isddeditMode=true;

    console.log(flightsch)
    this.flightSchParam.id = flightsch.id
    this.flightSchParam.flightName = flightsch.flightName
    this.flightSchParam.flightDepLoc = flightsch.flightDepLoc
    this.flightSchParam.flightArrLoc = flightsch.flightArrLoc
    this.flightSchParam.flightDepDate = flightsch.flightDepDate
    this.flightSchParam.flightArrDate = flightsch.flightArrDate
    this.flightSchParam.flightDepTime = flightsch.flightDepTime
    this.flightSchParam.flightArrTime = flightsch.flightArrTime
   //this.flightSchParam.flight.id = flightsch.flight?.id
    this.flightSchParam.flight.flightCompany = flightsch.flight?.flightCompany
    this.flightSchParam.flight.flightModel = flightsch.flight?.flightModel
    this.flightSchParam.flight.flightCode = flightsch.flight?.flightCode
    this.flightSchParam.flight.flightAvlStatus = flightsch.flight?.flightAvlStatus
    this.flightSchParam.flight.flightEcoSeats = flightsch.flight?.flightEcoSeats
    this.flightSchParam.flight.flightBuiSeats = flightsch.flight?.flightBuiSeats
    this.flightSchParam.flightfare.flightEcoFare = flightsch.flightfare?.flightEcoFare
    this.flightSchParam.flightfare.flightBuiFare = flightsch.flightfare?.flightBuiFare

    

    alert(this.flightSchParam.flight.id)




  }


  public updateFlightSchedule() {


    console.log("After : " + this.flightSchParam.flightDepTime);
    let response = this.managescheduleservice.updateFlightSchedule(this.flightSchParam, this.flightSchParam.id)
    response.subscribe((data) => {
      console.log(data);
      alert("Updated Successfully");
      this.flightSchForm.reset();
      this.getAllFLightSchedule();
    }, err => {
      alert("Something Went Wrong");
    }
    )
  }




  public clearForm() {

    this.flightSchForm.reset();

  }

  

}
