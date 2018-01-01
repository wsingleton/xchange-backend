package com.xchange.services;

import java.util.List;

import com.xchange.models.Company;

public interface CompanyService {
	
	public List<Company> getAllCompanies();
	public Company getCompanyById(Long id);
	public List<Company> getCompaniesByName(String name);
	public List<Company> getCompaniesBySymbol(String symbol);
	public List<Company> getCompaniesBySector(String sector);
	public List<Company> getCompaniesByExchange(String exchange);
	public List<Company> getCompaniesByIndustry(String industry);

}
