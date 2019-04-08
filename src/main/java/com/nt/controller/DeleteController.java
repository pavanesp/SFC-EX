package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeDto;
import com.nt.service.EmployeService;

public class DeleteController extends AbstractController{

	private EmployeService service;

	public DeleteController(EmployeService service) {
		
		this.service = service;
	}
	
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub

		int getId=Integer.parseInt(request.getParameter("empNo"));
		System.out.println("========"+getId);

		String getMsg=service.deleteRecord(getId);
		
			ModelAndView mav=new ModelAndView();
			
			List<EmployeDto> ldto=service.fetchEmployes();
			
			
	mav.addObject("getMsg",getMsg);
	   mav.addObject("ldto",ldto);
	   mav.setViewName("GetEmployes");
	   mav.setViewName("GetEmployes");

	return mav;
		
		
	}
	
	
}
