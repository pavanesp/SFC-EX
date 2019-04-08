package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeDto;
import com.nt.service.EmployeService;

public class FetchEmployeDetailsController extends AbstractController{

	private EmployeService service;
	
	
	public FetchEmployeDetailsController(EmployeService service) {
		super();
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<EmployeDto> ldto=service.fetchEmployes();
		
		return new ModelAndView("GetEmployes","ldto",ldto);
	}

}
