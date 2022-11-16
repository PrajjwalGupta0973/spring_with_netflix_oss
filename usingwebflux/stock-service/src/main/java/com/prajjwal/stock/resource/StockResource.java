package com.prajjwal.stock.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajjwal.stock.domain.Stock;
import com.prajjwal.stock.service.StockService;

@RestController
@RequestMapping("/api/v1")
public class StockResource {

	@Autowired
	private StockService stockService;

	@GetMapping("/stock/{stockCode}")
	public ResponseEntity<Stock> getWeather(@PathVariable("stockCode") String stockCode) {
		return ResponseEntity.ok(stockService.getStockByCode(stockCode));
	}
}
