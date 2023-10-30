package com.nada.employes.service;

import java.util.List;
import java.util.stream.Collectors;

import com.nada.employes.dto.EmployeDTO;
import com.nada.employes.repos.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.nada.employes.entities.grade;
import com.nada.employes.entities.employe;
import com.nada.employes.repos.EmployeRepository;


@Service
@SpringBootApplication
public class EmployeServiceImpl implements EmployeService{

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	ImageRepository imageRepository;


	@Override
	public EmployeDTO saveEmploye(EmployeDTO p) {
		return convertEntityToDto( employeRepository.save(convertDtoToEntity(p)));
	}


	@Override
	public EmployeDTO updateEmploye(EmployeDTO p) {
		return convertEntityToDto(employeRepository.save(convertDtoToEntity(p)));
	}


	@Override
	public void deleteEmploye(employe emp) {
		employeRepository.delete(emp);
	}

	@Override
	public void deleteEmployeById(Long id) {
		employeRepository.deleteById(id);
	}

    @Override
	public EmployeDTO getEmploye(Long id) {
		return convertEntityToDto( employeRepository.findById(id).get());

	}

    @Override
	public List<EmployeDTO> getAllEmployes() {
		return employeRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<employe> findByNomEmploye(String nom) {
		// TODO Auto-generated method stub
		return employeRepository.findByNomEmploye(nom);
	}

	@Override
	public List<employe> findByNomEmployeContains(String nom) {
		// TODO Auto-generated method stub
		return employeRepository.findByNomEmployeContains(nom);
	}

	@Override
	public List<employe> findByNomSalaire(String nom, Double salaire) {
		// TODO Auto-generated method stub
		return employeRepository.findByNomsalaire(nom, salaire);
	}

	@Override
	public List<employe> findByGrade(grade grade) {
		// TODO Auto-generated method stub
		return employeRepository.findByGrade(grade);
	}

	@Override
	public List<employe> findByGradeIdG(Long id) {
		// TODO Auto-generated method stub
		return employeRepository.findByGradeIdG(id);
	}

	@Override
	public List<employe> findByOrderByNomEmployeAsc() {
		// TODO Auto-generated method stub
		return employeRepository.findByOrderByNomEmployeAsc();
	}


	@Override
	public List<employe> trierEmployesNomSalaire(){
		// TODO Auto-generated method stub
		return employeRepository.trierEmployesNomsSalaire();
	}
	@Autowired
	ModelMapper modelMapper;
	@Override
	public EmployeDTO convertEntityToDto(employe employe) {
		EmployeDTO employeDTO = modelMapper.map(employe, EmployeDTO.class);
		return employeDTO;
	}


	/*@Override
	public employe convertDtoToEntity(EmployeDTO employeDto) {
		employe emp= new employe();
		emp.setIdEmploye(employeDto.getIdEmploye());
		emp.setNomEmploye(employeDto.getNomEmploye());
		emp.setSalaireEmploye(employeDto.getSalaireEmploye());
		emp.setDate(employeDto.getDate());
		emp.setGrade(employeDto.getGrade());
		emp.setImage(employeDto.getImage());
		return emp;
	}*/

	@Override
	public employe convertDtoToEntity(EmployeDTO employeDTO) {
		employe employe = new employe();
		employe = modelMapper.map(employeDTO, employe.class);
		return employe;
	}


	/*@Override
	public EmployeDTO convertEntityToDto(employe employe) {
		EmployeDTO employeDTO = modelMapper.map(employe, EmployeDTO.class);
		return employeDTO;
	}*/


	/*@Override
	public EmployeDTO saveEmploye(employe p) {
		return convertEntityToDto( employeRepository.save(p));
	}*/

	/*@Override
	public EmployeDTO getEmploye(Long id) {
		return convertEntityToDto( employeRepository.findById(id).get());
	}*/

	/*@Override
	public List<EmployeDTO> getAllEmployes() {
		return employeRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());

	}*/


	/*@Override
	public employe convertDtoToEntity(EmployeDTO employeDTO) {
		employe employe = new employe();
		employe = modelMapper.map(employeDTO, employe.class);
		return employe;
	}*/

	/*@Override
	public EmployeDTO saveEmploye(EmployeDTO p) {
		return convertEntityToDto( employeRepository.save(convertDtoToEntity(p)));
	}
	@Override
	public EmployeDTO updateEmploye(EmployeDTO p) {
		return convertEntityToDto(employeRepository.save(convertDtoToEntity(p)));
	}
*/



}
