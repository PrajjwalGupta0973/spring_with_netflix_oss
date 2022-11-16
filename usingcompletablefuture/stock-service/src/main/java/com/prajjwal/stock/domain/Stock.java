package com.prajjwal.stock.domain;

public class Stock {

	private String stockCode;
	private String description;

	public Stock(String stockCode, String description) {
		this.stockCode = stockCode;
		this.description = description;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
