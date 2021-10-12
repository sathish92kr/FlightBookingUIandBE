import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {



  transform(value: any[], searchString: any):any {

    if (!searchString) {
      console.log('no search')
      return value
    }

    return value.filter(it => {
      const flightCompany = it.flightCompany.toString().includes(searchString.toLowerCase())
      const flightModel = it.flightModel.toLowerCase().includes(searchString.toLowerCase())
      const flightCode = it.flightCode.toLowerCase().includes(searchString.toLowerCase())
      console.log(flightCompany + flightModel + flightCode);
      return (flightCompany + flightModel + flightCode);
    })
  }



}
