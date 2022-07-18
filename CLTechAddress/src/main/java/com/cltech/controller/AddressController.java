package com.cltech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cltech.crud.bean.ResponseBean;
import com.cltech.model.AddressModel;
import com.cltech.service.AddessService;


@RestController
@RequestMapping("/cltech")
public class AddressController {

	@Autowired
	AddessService saveaddress;

	@GetMapping("/address")

	public ResponseBean getAddress() {
		ResponseBean rs = saveaddress.getAllAddress();

		return rs;
	}

	@PostMapping("/saveaddress")
//	@RequestMapping(value = "/saveaddress", method = RequestMethod.POST)

	public ResponseBean saveAddress(@RequestBody AddressModel e) {

		return saveaddress.saveAddress(e);
	}
	
	@PutMapping("/updateaddress")
	public AddressModel updateAddress(@RequestBody AddressModel e) {
		return saveaddress.updateAddress(e);
	}
	

	@DeleteMapping("/address/{id}")
	public ResponseBean DeleteById(@PathVariable("id") Long id) {
		return saveaddress.DeleteById(id);
	}


	@GetMapping("/address/{id}")
	public ResponseBean getAddressById(@PathVariable Long id) {
		return saveaddress.getAddressById(id);
	}
}