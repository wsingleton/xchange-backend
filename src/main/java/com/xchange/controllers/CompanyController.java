package com.xchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xchange.models.Company;
import com.xchange.services.CompanyService;

@CrossOrigin
@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	CompanyService service;
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:48
	@RequestMapping(value="/GetCompanyById", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Company getCompanyById(@RequestBody Company company) {
		System.out.println("[LOG] - In /GetCompanyById");
		System.out.println(service.getCompanyById(company.getCompanyId()));
		return service.getCompanyById(company.getCompanyId());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:51
	// [DEV] - Changed return type to List<Company> since some company symbols are used on multiple exchanges
	@RequestMapping(value="/GetCompaniesBySymbol", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesBySymbol(@RequestBody Company company) {
		System.out.println("[LOG] - In /GetCompanyBySymbol");
		System.out.println(service.getCompaniesBySymbol(company.getSymbol()));
		return service.getCompaniesBySymbol(company.getSymbol());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 00:55
	// [DEV] - Changed return type to List<Company> since some company names are used on multiple exchanges
	@RequestMapping(value="/GetCompaniesByName", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesByName(@RequestBody Company company) {
		System.out.println("[LOG] - In /GetCompanyByName");
		System.out.println(service.getCompaniesByName(company.getName()));
		return service.getCompaniesByName(company.getName());
	}
	
	// [DEV] - Method tested using Postman by WS on 27DEC2017 16:45
	@RequestMapping(value="/GetAllCompanies", method=RequestMethod.GET)
	public List<Company> getAllCompanies() {
		System.out.println("[LOG] - In /GetAllCompanies");
		System.out.println(service.getAllCompanies());
		return service.getAllCompanies();
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 01:22
	@RequestMapping(value="/GetCompaniesByExchange", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesByExchange(@RequestBody Company company) {
		System.out.println("[LOG] - In /GetCompaniesByExchange");
		System.out.println(service.getCompaniesByExchange(company.getExchange()));
		return service.getCompaniesByExchange(company.getExchange());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 01:10
	@RequestMapping(value="/GetCompaniesBySector", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesBySector(@RequestBody Company company) {
		System.out.println("[LOG] - In /GetCompaniesBySector");
		System.out.println(service.getCompaniesBySector(company.getSector()));
		return service.getCompaniesBySector(company.getSector());
	}
	
	// [DEV] - Method tested using Postman by WS on 28DEC2017 01:19
	@RequestMapping(value="/GetCompaniesByIndustry", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public List<Company> getCompaniesByIndustry(@RequestBody Company company) {
		System.out.println("[LOG] - In /GetCompaniesByIndustry");
		System.out.println(service.getCompaniesByIndustry(company.getIndustry()));
		return service.getCompaniesByIndustry(company.getIndustry());
	}
	
}