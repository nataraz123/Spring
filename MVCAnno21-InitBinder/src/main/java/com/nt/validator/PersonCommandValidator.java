package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.PersonCommand;
@Component
public class PersonCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(PersonCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PersonCommand cmd=null;
		//type casting
		cmd=(PersonCommand) target;
		//server side form validation logic
		
		if( cmd.getName()==null || cmd.getName().length()==0 || cmd.getName().equals(""))
			 errors.rejectValue("name", "perCmd.name.required");
		if(cmd.getAge()<0 || cmd.getAge()>100)
			errors.rejectValue("age", "perCmd.age.range");
		if(cmd.getHobies()==null || cmd.getHobies().length==0)
			errors.rejectValue("hobies", "perCmd.hobies.required");

	}

}
