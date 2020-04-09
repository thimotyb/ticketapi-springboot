package it.sisalpay.ticketservice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.sisalpay.ticketservice.model.Ticket;
import it.sisalpay.ticketservice.repository.TicketDAO;
import it.sisalpay.ticketservice.service.TicketServiceImpl;

@SpringBootTest
class TicketServiceApiApplicationTests {

	@Mock
	TicketDAO dao;
	
	@Autowired
	@InjectMocks
	TicketServiceImpl ticketService;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void shouldGetSuccessiveTicketNumber() {
				
		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int firstTicketNumber = ticketService.buyTicket("Alessandra", "4321");
		when(dao.createTicket(any(Ticket.class))).thenReturn(2);
		int secondTicketNumber = ticketService.buyTicket("Francesco", "1234");
		
		// Assert First
		assertTrue(secondTicketNumber == firstTicketNumber+1, ()->"Il biglietto comprato dopo ha il numero successivo"
				);
		
	}

}
