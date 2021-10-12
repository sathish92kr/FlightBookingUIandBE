package com.flight.dbservice.config;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.flight.dbservice.model.Flight;
import com.flight.dbservice.model.FlightFare;
import com.flight.dbservice.model.FlightSchedule;
import com.flight.dbservice.model.FlightSeats;
import com.flight.dbservice.repo.FlightFareRepo;
import com.flight.dbservice.repo.FlightRepo;
import com.flight.dbservice.repo.FlightScheduleRepo;
import com.flight.dbservice.repo.FlightSeatsRepo;

//@Component
public class DBDataLoader {

	@Bean
	public CommandLineRunner mappingDemo(FlightScheduleRepo flightSchrepo, FlightSeatsRepo flightSeatsrepo,
			FlightFareRepo flightFarerepo, FlightRepo flightrepo) {
		return args -> {
			flightSeatsrepo.deleteAllInBatch();
			flightFarerepo.deleteAllInBatch();
			flightSchrepo.deleteAllInBatch();
			flightrepo.deleteAllInBatch();

			Flight flight1 = new Flight("Kingfisher", "KIN360", 80, 30, "Available", "KIN85363");

			Flight flight = new Flight("Indigo", "IND360", 60, 40, "Available", "IND56790");

			FlightFare flightfare = new FlightFare(1500, 2000);
			FlightFare flightfare2 = new FlightFare(2500, 3500);

			FlightSeats flightseats = new FlightSeats(20, 30);
			FlightSeats flightseats1 = new FlightSeats(30, 15);
			FlightSeats flightseats2 = new FlightSeats(50, 17);
			FlightSeats flightseats3 = new FlightSeats(25, 26);

			flightSeatsrepo.save(flightseats);
			flightSeatsrepo.save(flightseats1);
			flightSeatsrepo.save(flightseats2);
			flightSeatsrepo.save(flightseats3);

			flightFarerepo.save(flightfare);
			flightFarerepo.save(flightfare2);

			flightrepo.save(flight);
			flightrepo.save(flight1);

			FlightSchedule flightSchedule = new FlightSchedule("IND93BTC", "HYDERABAD", "DELHI",
					LocalDate.parse("2021-12-31"), LocalDate.parse("2021-12-30"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), flight);

			flightSchedule.setFlightfare(flightfare);
			flightSchedule.setFlightseats(flightseats);

			FlightSchedule flightSchedule1 = new FlightSchedule("KIN96MTC", "CHENNAI", "COIMBATORE",
					LocalDate.parse("2021-12-31"), LocalDate.parse("2021-12-27"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), flight);
			flightSchedule1.setFlightseats(flightseats1);
			flightSchedule1.setFlightseats(flightseats2);
			FlightSchedule flightSchedule2 = new FlightSchedule("KIN96CTT", "CHENNAI", "TIRUPATHI",
					LocalDate.parse("2021-12-26"), LocalDate.parse("2021-12-26"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), flight1);
			flightSchedule2.setFlightfare(flightfare2);
			flightSchedule2.setFlightseats(flightseats3);

			FlightSchedule flightSchedule3 = new FlightSchedule("KIN96TTC", "TIRUPATHI", "CHENNAI",
					LocalDate.parse("2021-12-31"), LocalDate.parse("2021-12-31"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), null);
			flightSchedule3.setFlightfare(flightfare2);
			flightSchedule3.setFlightseats(flightseats1);
			FlightSchedule flightSchedule4 = new FlightSchedule("IND94BTC", "CHENNAI", "COIMBATORE",
					LocalDate.parse("2021-12-28"), LocalDate.parse("2021-12-28"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), flight);
			flightSchedule4.setFlightfare(flightfare2);
			flightSchedule4.setFlightseats(flightseats1);
			FlightSchedule flightSchedule5 = new FlightSchedule("IND95BTC", "CHENNAI", "COIMBATORE",
					LocalDate.parse("2021-12-27"), LocalDate.parse("2021-12-27"), LocalTime.parse("10:59:59"),
					LocalTime.parse("12:59:59"), flight);

			flightSchedule5.setFlightfare(flightfare);
			flightSchedule5.setFlightseats(flightseats3);

			FlightSchedule flightSchedule6 = new FlightSchedule("IND95BTC", "CHENNAI", "DELHI",
					LocalDate.parse("2021-12-31"), LocalDate.parse("2021-12-30"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), flight);

			flightSchedule6.setFlightfare(flightfare2);
			flightSchedule6.setFlightseats(flightseats2);

			FlightSchedule flightSchedule7 = new FlightSchedule("IND92BTC", "MYSORE", "DELHI",
					LocalDate.parse("2021-12-28"), LocalDate.parse("2021-12-28"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), flight);

			flightSchedule7.setFlightfare(flightfare2);
			flightSchedule7.setFlightseats(flightseats1);

			FlightSchedule flightSchedule8 = new FlightSchedule("IND91BTC", "MUMBAI", "DELHI",
					LocalDate.parse("2021-12-31"), LocalDate.parse("2021-12-30"), LocalTime.parse("21:59:59"),
					LocalTime.parse("23:59:59"), flight);
			flightSchedule8.setFlightfare(flightfare);
			flightSchedule8.setFlightseats(flightseats3);

			flightSchrepo.save(flightSchedule);
			flightSchrepo.save(flightSchedule1);
			flightSchrepo.save(flightSchedule2);
			flightSchrepo.save(flightSchedule3);
			flightSchrepo.save(flightSchedule4);
			flightSchrepo.save(flightSchedule5);
			flightSchrepo.save(flightSchedule6);
			flightSchrepo.save(flightSchedule7);
			flightSchrepo.save(flightSchedule8);

		};
	}

}
