package com.prajjwal.stock.service;

import org.springframework.stereotype.Service;

import com.prajjwal.stock.domain.Stock;

@Service
public class StockService {

	public Stock getStockByCode(String stockCode) {
		return new Stock(stockCode, "telestra");
	}
}
