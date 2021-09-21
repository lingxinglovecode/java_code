package com.xinglian.contact;

public class TriAngle {
	private float base;
	private float height;
	
	public TriAngle(float i, float j){
		base = i;
		height =j;
	}
	
	public void setBase(float i) {
		base = i;
	}
	public void setHeigt(float j) {
		height = j;
	}
	public float getBase() {
		return base;
	}
	public float getHight() {
		return height;
	}

	public void getArea() {
		float area = base * height;
		System.out.print(area);
	}
}
