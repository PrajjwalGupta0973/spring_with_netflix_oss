package com.prajjwal.homepage.domain;

public class Homepage {

	private Weather weather;
	private Stock stock;

	public Homepage(Weather weather, Stock stock) {
		this.weather = weather;
		this.stock = stock;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
