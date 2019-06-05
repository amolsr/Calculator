package com.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	@SuppressWarnings("rawtypes")
	private List<Comparable> displayList = new ArrayList<Comparable>();
	private List<Double> numList = new ArrayList<Double>();
	private List<Character> OpList = new ArrayList<Character>();
	private Double temp;
	private String str;

	public Model() {
		temp = 0d;
		str = "";
	}

	public void setDisplayList(@SuppressWarnings("rawtypes") List<Comparable> displayList) {
		this.displayList = displayList;
	}

	public void setNumList(List<Double> numList) {
		this.numList = numList;
	}

	public void setOpList(List<Character> opList) {
		this.OpList = opList;
	}

	public void setDisplayList() {
		displayList.clear();
	}

	public void setDisplayList(Character c) {
		displayList.add(c);
	}

	public void setDisplayList(Double n) {
		displayList.add(n);
	}

	@SuppressWarnings("rawtypes")
	public List<Comparable> getDisplayList() {
		return this.displayList;
	}
	
	public void setNumList(Double n) {
		numList.add(n);
	}
	
	public void setOpList(Character c) {
		OpList.add(c);
	}

	public List<Character> getOpList() {
		return OpList;
	}

	public Double getTemp() {
		return temp;
	}

	public List<Double> getNumList() {
		return numList;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
