package com.main;

import java.util.List;
import java.util.logging.Level;

import com.dao.StoreCustomerCountryDAO;
import com.dao.StoreCustomerCountryDAOImpl;
import com.vo.StoreVO;

public class Main {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

// 		 1. Quante persone lavorano in uno store (il risultato sarà fatto da due colonne: 
//		    address dello store e numero di impiegati)
//		
//		AddressStaffStoreDAO dao = new AddressStaffStoreDAOImpl();
//
//		List<AddressVO> staffPerStore = dao.getNumStaffPerStore();
//
//		staffPerStore.forEach(System.out::println);

//		2. Quanti film sono di una certa categoria (//)
//				
//		FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAOImpl();
//
//		String categoryToSearch = "Action";
//		List<CategoryVO> numFilmsPerOneCategory = filmCategoryDAO.getNumFilmsPerOneCategory(categoryToSearch);
//		numFilmsPerOneCategory.forEach(System.out::println);

//		3. Tutti i film di categoria x ordinati in modo decrescente per titolo

//		FilmCategoryDAO filmCategoryDAO = new FilmCategoryDAOImpl();
//
//		String categoryToSearch = "Action";
//		List<FilmVO> films = filmCategoryDAO.getFilmsByCategoryDesc(categoryToSearch);
//		films.forEach(System.out::println);

//		4. Tutti gli attori, in ordine crescente per nome and cognome, che hanno recitato in un determinato film

//		FilmActorDAO filmActorDAO = new FilmActorDAOImpl();
//
//		String filmToSearch = "WORST BANGER";
//		List<ActorVO> actors = filmActorDAO.getActorsByFilm(filmToSearch);
//		actors.forEach(System.out::println);

//		5. Inserire la propria nemesi come impiegato all'interno di uno store

//		StaffDAO staffDAO = new StaffDAOImpl();
//		Staff staff = new Staff("Giulio", "Grimani", 1, 3, "giulio.grimani@visioture.com", "giulio", "flyinCircus",
//				new Store(1));
//		staffDAO.insertStaff(staff);

//		6. Inserire tutta la propria famiglia come customer di uno store

//		CustomerDAO customerDAO = new CustomerDAOImpl();
//
//		Customer c1 = new Customer(1, new Address(1), "martina.graffeo@gmail.com", "Martina", "Graffeo", new Store(1));
//		Customer c2 = new Customer(1, new Address(1), "giacomo.graffeo@gmail.com", "Giacomo", "Graffeo", new Store(1));
//		Customer c3 = new Customer(1, new Address(1), "valeria.mancuso@gmail.com", "Valeria", "Mancuso", new Store(1));
//
//		List<Customer> customers = new ArrayList<Customer>();
//
//		customers.add(c1);
//		customers.add(c2);
//		customers.add(c3);
//
//		customerDAO.insertBulkCustomers(customers);

//		7. Elenca tutti i film in cui hanno recitato esattamente n attori

//		FilmActorDAO filmActorDAO = new FilmActorDAOImpl();
//		Integer numActors = 10;
//		filmActorDAO.getFilmsByNumActors(numActors).forEach(System.out::println);

//		8. Elenco di tutti i film in cui ha recitato l'attore x 

//		FilmActorDAO filmActorDAO = new FilmActorDAOImpl();
//		String firstName = "PENELOPE";
//		String lastName = "GUINESS";
//		filmActorDAO.getFilmsByActor(firstName, lastName).forEach(System.out::println);

//		9. Store che hanno customers residenti in un determinato country

		StoreCustomerCountryDAO storeCustomerCountryDAO = new StoreCustomerCountryDAOImpl();
		String countryToSearch = "United States";
		List<StoreVO> stores = storeCustomerCountryDAO.getStorePerCustomerInCountry(countryToSearch);

		stores.forEach(System.out::println);

//		10. Nome, cognome e pagamento complessivo di un determinato customer
//		
//		CustomerPaymentDAO customerPaymentDAO = new CustomerPaymentDAOImpl();
//		List<CustomerVO> customersAmounts = customerPaymentDAO.getTotalAmountPerCustomer();
//		customersAmounts.forEach(System.out::println);

//		11. Dato un determinato attore ed una lista di film, far figurare che tale 
//		attore ha recitato in tutti i film della lista

//		FilmActorDAO filmActorDAO = new FilmActorDAOImpl();
//		List<Film> films = new ArrayList<Film>();
//
//		Film f1 = new Film("Titolo1", "Descrizione1");
//		Film f2 = new Film("Titolo2", "Descrizione2");
//
//		Actor a1 = new Actor("Roberto", "Graffeo");
//
//		films.add(f1);
//		films.add(f2);
//
//		filmActorDAO.insertActorFilms(a1, films);

	}
}
