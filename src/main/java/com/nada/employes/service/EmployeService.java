package com.nada.employes.service;

import java.util.List;

import com.nada.employes.dto.EmployeDTO;
import com.nada.employes.entities.grade;
import com.nada.employes.entities.employe;



public interface EmployeService {

	EmployeDTO updateEmploye(EmployeDTO emp);
	void deleteEmploye(employe p);
	void deleteEmployeById(Long id);

	List<employe> findByNomEmploye(String nom);
	List<employe> findByNomEmployeContains(String nom);
	List<employe> findByNomSalaire (String nom, Double salaire);
	List<employe> findByGrade (grade grade);
	List<employe> findByOrderByNomEmployeAsc();
	List<employe> trierEmployesNomSalaire();
	List<employe> findByGradeIdG(Long id);

	EmployeDTO convertEntityToDto (employe employe);
	EmployeDTO saveEmploye(EmployeDTO e);
	EmployeDTO getEmploye(Long id);
	List<EmployeDTO> getAllEmployes();

	employe convertDtoToEntity(EmployeDTO employeDto);








}
