import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'multiSearchFlight',
  pure: true
})
export class MultiSearchFlightPipe implements PipeTransform {

  transform(items: any, flightCompanySearch: any, flightModelSearch: any, flightCodeSearch: any) {
    if (items && items.length) {
      return items.filter(item => {
        if (flightCompanySearch && item.flightCompany.toLowerCase().indexOf(flightCompanySearch.toLowerCase()) === -1) {
          return false;
        }
        if (flightModelSearch && JSON.stringify(item.flightModel).toLowerCase().indexOf(flightModelSearch.toLowerCase()) === -1) {
          return false;
        }
        if (flightCodeSearch && item.flightCode.toLowerCase().indexOf(flightCodeSearch.toLowerCase()) === -1) {
          return false;
        }
        return true;
      })
    }
    else {
      return items;
    }
  }

}
