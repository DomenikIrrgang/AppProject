package com.DCStudios.AppProjectXXX.Grounds;

import com.DCStudios.AppProjectXXX.Background.Ground;
import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Grass extends Ground {

	public Grass(Vector2 position, Measure measure) {
		super(position, measure, new Texture("data/grass.jpg"));
	}

}
