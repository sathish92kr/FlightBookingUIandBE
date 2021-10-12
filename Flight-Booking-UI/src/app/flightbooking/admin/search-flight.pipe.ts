import { Pipe, PipeTransform } from '@angular/core';

export interface IFlightSearch {
  flightCompany: any;
  flightModel: any;
  flightCode: any;
 }

@Pipe({
  name: 'searchFlight'
})
export class SearchFlightPipe implements PipeTransform {

  transform(
    flights: IFlightSearch[],
    flightCompanySearch?: string,
    flightModelSearch?: string,
    flightCodeSearch?: string
  ): IFlightSearch[] {

    if (!flights) return [];
    if (!flightCompanySearch) return flights;
    flightCompanySearch = flightCompanySearch.toLocaleLowerCase();
    flights = [...flights.filter(flight => flight.flightCompany.toLocaleLowerCase().includes(flightCompanySearch))];

    if (!flightModelSearch) return flights;
    flightModelSearch = flightModelSearch.toLocaleLowerCase();
    flights = [...flights.filter(flight => flight.flightModel.toLocaleLowerCase().includes(flightModelSearch))];

    if (!flightCodeSearch) return flights;
    flightCodeSearch = flightCodeSearch.toLocaleLowerCase();
    flights = [...flights.filter(flight => flight.flightCode.toLocaleLowerCase().includes(flightCodeSearch))];

    return flights;
  }

}
