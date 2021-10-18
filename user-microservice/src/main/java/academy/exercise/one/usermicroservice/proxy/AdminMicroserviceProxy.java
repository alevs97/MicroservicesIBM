package academy.exercise.one.usermicroservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import academy.exercise.one.usermicroservice.models.AdminMicroservice;

@FeignClient(name="admin-microservice")
public interface AdminMicroserviceProxy {
	
	@GetMapping("/passion/{passion}/salary/{salary}/age/{age}")
	public AdminMicroservice retrieveAdminMicroservice(
			@PathVariable("passion") String passion,
			@PathVariable("salary") Double salary,
			@PathVariable("age") Integer age);
	
}
