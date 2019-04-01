package com.howtodoinjava.controller;

import java.util.Random;

import org.apache.lucene.store.MMapDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtodoinjava.entity.EmployeeEntity;
import com.howtodoinjava.entity.VehicleEntity;
import com.howtodoinjava.service.EmployeeManager;
import com.howtodoinjava.service.VehicleManager;

@Controller
public class EditEmployeeController {



	@Autowired
	private EmployeeManager employeeManager;

	@Autowired
	private VehicleManager vehicleManager;

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/register";
	}
	 */
	/*
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {

		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployees());

		return "editEmployeeList";
	}*/

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value ="employee") EmployeeEntity employee) {
		System.err.println();
		Random r=new Random();
		int num=r.nextInt(900000)+100000;
		employee.setId(num);
		employeeManager.addEmployee(employee);
		return "redirect:/register";

	}


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "register";
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listVehicles(ModelMap map) {
		map.addAttribute("vehicle", new VehicleEntity());
		map.addAttribute("vehicleList", vehicleManager.getAllVehicles());
		return "list";
	}

	@RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
	public String addVehicle(
			@ModelAttribute(value = "vehicle") VehicleEntity vehicle,
			BindingResult result) {
		vehicleManager.addVehicle(vehicle);
		return "redirect:/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String goCreate(ModelMap model) {
		model.addAttribute("create", new VehicleEntity());
		return "create";
	}

	@RequestMapping("/delete/{vehicleNo}")
	public String deleteVehicle(@PathVariable("vehicleNo") String vehicleNo) {
		vehicleManager.deleteVehicle(vehicleNo);
		return "redirect:/list";
	}

	@RequestMapping("/edit/{vehicleNo}")
	public String editVehicle(@PathVariable("vehicleNo") String vehicleNo, ModelMap map) {
		VehicleEntity v1 = null;
		v1 = vehicleManager.getVehicleById(vehicleNo);
		map.addAttribute("vehicle", v1);
		return "update";
	}




	/*
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
	 */

}
