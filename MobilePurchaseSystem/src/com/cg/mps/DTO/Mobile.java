package com.cg.mps.DTO;

public class Mobile 
{
	int mobId;
	String name;
	int price;
	int quant;
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(int mobId, String name, int price, int quant) {
		super();
		this.mobId = mobId;
		this.name = name;
		this.price = price;
		this.quant = quant;
	}
	@Override
	public String toString() {
		return "Mobile [mobId=" + mobId + ", name=" + name + ", price=" + price
				+ ", quant=" + quant + "]";
	}
	public int getMobId() {
		return mobId;
	}
	public void setMobId(int mobId) {
		this.mobId = mobId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
}
