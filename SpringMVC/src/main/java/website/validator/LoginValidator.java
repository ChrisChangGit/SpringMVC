package website.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import website.orm.LoginBean;

@Service(value = "loginValidator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
//		return LoginBean.class.equals(clazz);
		return LoginBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", "account.required", "plaese input account");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", "plaese input password");
		
	}
	
}
