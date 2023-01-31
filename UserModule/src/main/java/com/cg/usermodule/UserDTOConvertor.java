package com.nv.usermodule.util;

import org.springframework.stereotype.Component;

import com.nv.usermodule.dto.UserDTO;
import com.nv.usermodule.entity.User;

@Component
public class UserDTOConvertor {

	public UserDTO convertTo(User user) {

		return new UserDTO(user.getUserId(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(),user.getEmailId(),
				user.getAddress());
	}
	
	
	

}
