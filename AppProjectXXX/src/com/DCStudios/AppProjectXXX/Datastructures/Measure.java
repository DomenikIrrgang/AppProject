package com.DCStudios.AppProjectXXX.Datastructures;

public class Measure {
	public float height;
	public float width;
	
	public Measure(float width, float height) {
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		return "height: " + height + " width: " + width;
	}
}
