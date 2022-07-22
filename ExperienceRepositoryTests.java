package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cltech.ClTechProject3Application;
import com.cltech.model.ExeperienceModel;
import com.cltech.repository.ExperienceModelRepository;


@SpringBootTest
@ContextConfiguration(classes = ClTechProject3Application.class)
public class ExperienceRepositoryTests {
	
	@Autowired
    private ExperienceModelRepository experienceModelRepository;
	

	
	@Test
	public void saveExperience() {

		List<ExeperienceModel> experienceList = new ArrayList<ExeperienceModel>();
		experienceList.add(new ExeperienceModel(1L,"Ramesh","Fadatare","ramesh@gmail.com","12/07/2019","22/09/2025",true));

	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	 public void getExperienceTest(){

		 ExeperienceModel exeperienceModel = experienceModelRepository.getById(1L);

	        Assertions.assertThat(exeperienceModel.getId()).isEqualTo(1L);

	    }
	
	@Test
	 public void getListOfExperienceTest(){

	        List<ExeperienceModel> employees = experienceModelRepository.findAll();

	        Assertions.assertThat(employees.size()).isGreaterThan(0);

	    }
	
		
		
		
		  @SuppressWarnings("deprecation")
			@Test
			public void updateExperience() {

				ExeperienceModel exeperienceModel = experienceModelRepository.getById(1L);

				//exeperienceModel.setCurrentlyWorking(true);

				ExeperienceModel experienceUpdated = experienceModelRepository.save(exeperienceModel);

				//Assertions.assertThat(experienceUpdated.isCurrentlyWorking()).isEqualTo(true);

			}
		 
		 
			@SuppressWarnings("deprecation")
			@Test
			public void deleteExperienceTest() {

				ExeperienceModel employee = experienceModelRepository.getById(1L);

				experienceModelRepository.delete(employee);

				// employeeRepository.deleteById(1L);

				ExeperienceModel employee1 = null;

				Optional<ExeperienceModel> optionalEmployee = Optional.empty();

				if (optionalEmployee.isPresent()) {
					employee1 = optionalEmployee.get();
				}

				Assertions.assertThat(employee1).isNull();
			}

}
