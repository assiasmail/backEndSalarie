package com.tsconsult.salarietest.service;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.tsconsult.salarietest.exceptions.FunctionalException;
import com.tsconsult.salarietest.model.Salarie;

public class SalarierServiceTest {
	
	@Test
	public void dedoublement() {
		SalarieService service = new SalarieServiceImpl();
		 String critere="Nom";
		List<Salarie> salaries= new ArrayList<>(); 
		List<Salarie> resultatAttendu= new ArrayList<>();
		salaries.add(new Salarie("Smail","Assia","Cité 90 logt, Draa-El-Mizan",LocalDate.of(1989, 2, 11), LocalDate.of(2017, 5, 7)));
		salaries.add(new Salarie("Smail","Sihem","Tigzirt",LocalDate.of(1985, 3, 23), LocalDate.of(2014, 9, 1)));
		salaries.add(new Salarie("Sihadj Mohand","Oualid","Alger",LocalDate.of(1985, 9, 22), LocalDate.of(2010, 1, 1)));
		
		resultatAttendu.add(new Salarie("Smail","Assia","Cité 90 logt, Draa-El-Mizan",LocalDate.of(1989, 2, 11), LocalDate.of(2017, 5, 7)));
		resultatAttendu.add(new Salarie("Sihadj Mohand","Oualid","Alger",LocalDate.of(1985, 9, 22), LocalDate.of(2010, 1, 1)));
		List<Salarie> actualList = service.filtreSalaries(salaries, critere);
		assertEquals(resultatAttendu.size(), actualList.size());
		actualList.forEach(s -> {
			resultatAttendu.contains(s);
		});
		
		assertThrows(FunctionalException.class , () -> service.filtreSalaries(salaries, "bla")).getMessage();
		
	
	}

}
