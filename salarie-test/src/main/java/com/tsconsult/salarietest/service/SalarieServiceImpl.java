package com.tsconsult.salarietest.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tsconsult.salarietest.model.Salarie;


@Service
public class SalarieServiceImpl implements SalarieService{
	Field field = null;
	boolean exists = false;
	
	@Override
	public List<Salarie> filtreSalaries(List<Salarie> salaries,String critere) throws Exception {
		
		List<Salarie> salariesFiltres = new ArrayList<>();
		field = Salarie.class.getDeclaredField(critere);
		field.setAccessible(true);
		salaries.stream().forEach(s -> {
			 exists= false;
			salariesFiltres.stream().forEach(sf -> {
				try {
					if(field.get(s).equals(field.get(sf))) {
						exists = true;
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			if(!exists) {
				salariesFiltres.add(s);
			}
		});
		return salariesFiltres;
		
	}
}
