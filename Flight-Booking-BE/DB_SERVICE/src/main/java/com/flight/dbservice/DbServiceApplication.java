package com.flight.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flight.dbservice.repo.FlightRepo;
import com.flight.dbservice.repo.FlightScheduleRepo;

@SpringBootApplication
public class DbServiceApplication {
//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}

	@Autowired
	private FlightRepo flightrepo;
	@Autowired
	private FlightScheduleRepo flightschrepo;

//	@Override
//	public void run(String... args) throws Exception {
//		// Clean up database tables
//
////		flightschrepo.deleteAllInBatch();
////		flightrepo.deleteAllInBatch();
//
//		Flight flight = new Flight("Indigo", "IND360", 60, 40, "Available","IND56789");
//		Flight fleet1 = new Flight("Kingfisher", "KIN360", 80, 30, "Available","KIN85362");
//
//		flightrepo.save(flight);
//		flightrepo.save(fleet1);
//		FlightSchedule flightSchedule = new FlightSchedule("IND93BTC", "CHENNAI", "BANGALORE",
//				LocalDate.parse("2021-12-31"), LocalDate.parse("2021-12-31"), LocalTime.parse("21:59:59"),
//				LocalTime.parse("23:59:59"), flight);
//
//		flightschrepo.save(flightSchedule);
//
//	}

}
