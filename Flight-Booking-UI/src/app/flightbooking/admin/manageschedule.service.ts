import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as _ from 'lodash';


@Injectable({
  providedIn: 'root'
})
export class ManagescheduleService {

  PATH_OF_API = 'http://localhost:8080/schedule';

  constructor(private httpclient: HttpClient) { }


  public getFlightSchedule() {
    return this.httpclient.get(this.PATH_OF_API + '/getallschedule', {
      responseType: 'json',
    });
  }

  public addFlightSchedule(flightSchParam: any) {
    return this.httpclient.post(this.PATH_OF_API + '/addSchedule', flightSchParam, { responseType: 'text' as 'json' });
  }

  public deleteSchedule(id: number) {
    return this.httpclient.delete(this.PATH_OF_API + '/deleteSchedule/' + id);
  }

  public updateFlightSchedule(flightSchParam: any, id: number) {
    return this.httpclient.put(this.PATH_OF_API + '/editSchedule/' + id, flightSchParam, { responseType: 'text' as 'json' });
  }


 

}
