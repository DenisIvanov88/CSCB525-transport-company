package org.example.fileWriter;

import org.example.dao.CompanyDao;
import org.example.entity.Company;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyFileWriterTest {

    @Test
    void writeCompaniesToFile() {
        List<Company> companies = CompanyDao.getCompaniesSortedByIncome();
        CompanyFileWriter.writeCompaniesToFile(companies, "companies_info.txt");
    }
}