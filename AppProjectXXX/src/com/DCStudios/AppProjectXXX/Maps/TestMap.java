package com.DCStudios.AppProjectXXX.Maps;

import box2dLight.Light;
import box2dLight.PointLight;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Map.Map;
import com.DCStudios.AppProjectXXX.Models.TestModel;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class TestMap extends Map {

	public TestMap(Screen screen) {
		super(screen);
		this.addEntity(new TestModel(new Vector2(5,5), new Measure(10,10)));
		Light light = new PointLight(rayHandler, 200, new Color(0.5f, 0.3f, 0.6f, 1f), 200f, 25f, 25f);
	}

}
