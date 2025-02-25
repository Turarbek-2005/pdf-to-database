package com.converter.pdf;

import com.converter.pdf.PdfParser.StudentRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class PdfApplication implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;

	public PdfApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(PdfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.update("DELETE FROM students");

		String pdfFilePath = "C:/Users/alibe/OneDrive/Рабочий стол/grants.pdf";
		List<String> lines = PdfReaderService.readPdfLines(pdfFilePath);

		List<StudentRecord> records = PdfParser.parsePdfLines(lines);

		DBService.insertRecords(jdbcTemplate, records);

		System.out.println("Данные успешно загружены в БД!");
	}
}
