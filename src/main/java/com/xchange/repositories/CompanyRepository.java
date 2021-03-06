package com.xchange.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xchange.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	public List<Company> getCompaniesBySymbol(String symbol);
	public List<Company> getCompaniesByName(String name);
	public List<Company> getCompaniesBySector(String sector);
	public List<Company> getCompaniesByExchange(String exchange);
	public List<Company> getCompaniesByIndustry(String industry);
	
}
