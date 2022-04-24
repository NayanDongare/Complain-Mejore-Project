package com.cybage.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.User;
import com.cybage.service.UserServiceImpl;


@RestController
@CrossOrigin("http://localhost:4200/")

public class UserController
{
	@Autowired
	private UserServiceImpl userService;
	
	//get all user
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers()
	{
		List<User>list=userService.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		userService.save(user);
		return new ResponseEntity<>("User added!!!",HttpStatus.OK);
	}
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody User user) {
		user.setId(id);
		User updateUser = userService.update(user);
		
		return new ResponseEntity<>("Updated user's Data!!!",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		boolean success=userService.deleteUser(id);

		return ResponseEntity.ok("user deleted");
		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id)
	{
        User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	
	}
	
	

		
		
	
	
}//main
