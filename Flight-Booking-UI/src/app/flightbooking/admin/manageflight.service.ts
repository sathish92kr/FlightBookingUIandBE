import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ManageflightService {

  PATH_OF_API = 'http://localhost:8080';

  constructor(private httpclient: HttpClient) { }

  public getFlights() {
    return this.httpclient.get(this.PATH_OF_API + '/flight/gelAllFlights', {
      responseType: 'json',
    });
  }

  addFlight(flightParam: any) {
    return this.httpclient.post(this.PATH_OF_API + '/flight/addFlight', flightParam, { responseType: 'text' as 'json' });
  }

  updateFlight(flightParam: any, id: number) {
    return this.httpclient.put(this.PATH_OF_API + '/flight/editFlight/' + id, flightParam, { responseType: 'text' as 'json' });
  }

  public deleteFlight(id: number) {
    return this.httpclient.delete(this.PATH_OF_API + '/flight/deleteFlight/' + id);
  }
}
