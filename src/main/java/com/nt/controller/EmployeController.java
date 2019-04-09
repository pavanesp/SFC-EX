package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.EmployeCommand;
import com.nt.dto.EmployeDto;
import com.nt.service.EmployeService;

public class EmployeController extends SimpleFormController{

	EmployeService service;
	
	private static final Logger logger = Logger.getLogger(EmployeController.class);

	
	
	public EmployeController(EmployeService service) {
		
		this.service = service;
	}



	public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,Object command,BindException errors) {
		
  EmployeCommand cmd=(EmployeCommand)command;		
		EmployeDto dto=new EmployeDto();
  BeanUtils.copyProperties(cmd,dto);
		System.out.println();
  System.out.println(dto.getDeptNo());
  
  
  //logs debug message
	if(logger.isDebugEnabled()){
		logger.debug("onSubmit is executed!");
	}
	
	//logs exception
	logger.error("This is Error message");
	
  
  
  String msg=service.insertRecords(dto);
  
		return new ModelAndView("result","getMsg",msg);	
	}
	
	
}
