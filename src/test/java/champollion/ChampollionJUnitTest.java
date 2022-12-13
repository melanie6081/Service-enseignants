package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;

	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
	}


	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
				"Un nouvel enseignant doit avoir 0 heures prévues");
	}

	@Test
	public void testAjouteHeures() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
		untel.ajouteEnseignement(uml, 0, 20, 0);

		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

	}

	@Test
	public void testSousService(){
		untel.ajouteEnseignement(uml,10,0,20);
		untel.ajouteEnseignement(java, 20,10,15);
		assertTrue(untel.enSousService(), "L'enseignant doit avoir moins de 192 heures de prévues : "+untel.heuresPrevues());
		untel.ajouteEnseignement(uml,20,150,20);
		assertFalse(untel.enSousService(), "L'enseignant doit avoir plus de 192 heures de prévues : "+untel.heuresPrevues());
	}

	@Test
	public void testAjoutIntervention(){
		untel.ajouteEnseignement(uml, 10, 5,15);
		LocalDate date = LocalDate.of(2022, 12, 24);
		Intervention inter = new Intervention(TypeIntervention.CM, date, 2,14 );
		untel.ajouteIntervention(inter);
		assertTrue(untel.getInterventions().contains(inter), "L'intervention créée doit apparaitre dans la liste d'interventions.");
		assertEquals(12,untel.resteAPlanifier(uml,TypeIntervention.CM), "Il doit rester 12h de CM à planifier.");
		Intervention inter2 = new Intervention(TypeIntervention.TD, date, 1,14 );
		untel.ajouteIntervention(inter2);
		assertEquals(4,untel.resteAPlanifier(uml,TypeIntervention.TD), "Il doit rester 5h de TD à planifier.");
		Intervention inter1 = new Intervention(TypeIntervention.TP, date, 3,14 );
		untel.ajouteIntervention(inter1);
		assertEquals(9,untel.resteAPlanifier(uml,TypeIntervention.TP), "Il doit rester 9h de TP à planifier.");
	}

}