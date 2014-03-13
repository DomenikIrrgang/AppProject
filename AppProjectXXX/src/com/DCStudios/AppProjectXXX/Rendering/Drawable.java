package com.DCStudios.AppProjectXXX.Rendering;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public interface Drawable {

	void draw(SpriteBatch batch);
	Vector2 getPosition();
	void setPosition(Vector2 position);
	Measure getMeasure();
	void setMeasure(Measure measure);
	
}
