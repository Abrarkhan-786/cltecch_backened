package com.cltech.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cltech.crud.bean.ResponseBean;
import com.cltech.model.AddressModel;
import com.cltech.repository.AddressModelRepository;
import com.cltech.service.AddessService;
import com.cltech.service.PropertyService;
import com.springbootmysql.crud.constant.Status;

@Service
@Component
public class AddressServiceImpl implements AddessService {
	@Autowired
	@Qualifier("propertyServiceImpl")
	protected PropertyService propertyService;

	private static Logger LOGGER = LogManager.getLogger(AddressServiceImpl.class);
	@Autowired
	AddressModelRepository addressModelRepository;

	@Override
	public ResponseBean saveAddress(AddressModel address_model) {
		// TODO Auto-generated method stub
//		System.out.println("Save address called ");
		// propertyService.getAppProperty(GlobalConstant.ALLOWED_DECIMAL_POINTS);
		if (address_model == null) {
			return ResponseBean.builder().status(Status.FAIL).message("Data Is Null").build();
		}

		AddressModel addressBean = addressModelRepository.save(address_model);
		return ResponseBean.builder().status(Status.SUCCESS).message("Record Added Succesfully").response(addressBean)
				.build();

	}

	@Override
	public ResponseBean getAllAddress() {
		// check for if address is available or not
		List<AddressModel> addressList = addressModelRepository.findAll();

		if (addressList.isEmpty()) {
			return ResponseBean.builder().status(Status.FAIL).message("No Data Available").response(addressList)
					.build();
		}
		return ResponseBean.builder().status(Status.SUCCESS).message("All Records").response(addressList)
				.build();
	}

	@Override
	public AddressModel updateAddress(AddressModel e) {

		return addressModelRepository.save(e);
	}
	

	
	@Override
public ResponseBean DeleteById(Long id) {

	try {

		addressModelRepository.deleteById(id);
		return ResponseBean.builder().status(Status.SUCCESS).message("Deleted Successfully").build();
	} catch (Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
	}

}

	@Override
	public ResponseBean getAddressById(Long id) {
		AddressModel e = addressModelRepository.findById(id).get();

		try {
			if (e == null) {
				return ResponseBean.builder().status(Status.FAIL).message("No Data Found With This ID").build();
			} else {
				return ResponseBean.builder().status(Status.SUCCESS).message("This is the which found from database")
						.response(e).build();

			}

		} catch (Exception e1) {
			LOGGER.error(e1.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}




	
}


