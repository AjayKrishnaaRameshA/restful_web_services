package com.ajay.restful_api.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "UserDto Model Information"
)
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	public Long id;
	
	@Schema(
			description = "User first Name"
	)
	@NotEmpty(message = "first name should be entered")
	public String firstName;
	
	@Schema(
			description = "User last Name"
	)
	@NotEmpty(message = "last name should be entered")
	public String lastName;
	
	@Schema(
			description = "User email"
	)
	@NotEmpty(message = "email should be entered")
	@Email(message = "email should be valid")
	public String email;
	
}
