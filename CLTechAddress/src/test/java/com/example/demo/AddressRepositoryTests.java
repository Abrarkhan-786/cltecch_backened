package com.example.demo;



import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import com.cltech.model.AddressModel;
import com.cltech.repository.AddressModelRepository;

@DataJpaTest
@SpringBootTest
public class AddressRepositoryTests {
	
	@Autowired
    private AddressModelRepository addressModelRepository;
	

	/*
	 * @Order(1)
	 * 
	 * @Rollback(value = false)
	 */
	@Test
    public void saveAddressTest(){

		AddressModel addressModel = AddressModel.builder()
				.addressId(1L)
				.addressLine("Main lie sector")
				.country("India")
				.state("Maharastra")
				.city("Kalyan")
				.pincode("421 306")
                .build();

		addressModelRepository.save(addressModel);

        Assertions.assertThat(addressModel.getAddressId()).isGreaterThan(0);
    }
	
	@Test
	 public void getAddressById(){

		AddressModel addressModel = addressModelRepository.findById(1L).get();

	        Assertions.assertThat(addressModel.getAddressId()).isEqualTo(1L);

	    }
	
	@Test
	 public void getAllAddressTest(){

	        List<AddressModel> addressModel = addressModelRepository.findAll();

	        Assertions.assertThat(addressModel.size()).isGreaterThan(0);

	    }
	
	   @Test
	   public void updateEmployeeTest(){

		   AddressModel addressModel = addressModelRepository.findById(1L).get();

		   addressModel.setAddressId(2L);;

		   AddressModel addressModel1 =  addressModelRepository.save(addressModel);

	        Assertions.assertThat(addressModel1.equals(addressModel));

	    }
	   
	    @Test
	    public void DeleteByIdTest(){

			   AddressModel addressModel = addressModelRepository.findById(1L).get();

			   addressModelRepository.delete(addressModel);

	        //employeeRepository.deleteById(1L);

			   AddressModel addressModel1 = null;

	        Optional<AddressModel> optionaladdress = addressModelRepository.findById(1L);

	        if(optionaladdress.isPresent()){
	        	addressModel1 = optionaladdress.get();
	        }

	        Assertions.assertThat(addressModel1).isNull();
	    }



}