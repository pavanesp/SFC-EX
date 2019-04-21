package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.EmployeCommand;
import com.nt.dto.EmployeDto;
import com.nt.service.EmployeService;

public class EditController extends SimpleFormController{
	
	
	private EmployeService service;
	
	
	
	public EditController(EmployeService service) {
		
		this.service = service;
	}


	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		int getId=Integer.parseInt(request.getParameter("empNo"));
		EmployeDto dto=service.getEmployeById(getId);
		EmployeCommand cmd=null;
		cmd=new EmployeCommand();
		BeanUtils.copyProperties(dto, cmd);
        System.out.println("eeeeeeeeeeeeeeees");
		return cmd;
	}
	

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		// TODO Auto-generated method stub
	
		EmployeCommand cmd=(EmployeCommand)command;
		
		EmployeDto dto=new EmployeDto();
		
		BeanUtils.copyProperties(cmd, dto);
		
		System.out.println(dto.getEmpNo());
		
		
		//String getMsg=service.updateRecords(dto);
		String getMsg="Records are edited";
	
			ModelAndView mav=new ModelAndView();
			
			//List<EmployeDto> ldto=service.fetchEmployes();
			
			
	 mav.addObject("getMsg",getMsg);
	// mav.addObject("ldto",ldto);

	mav.setViewName("GetEmployes");
   	return mav;
	}

}
