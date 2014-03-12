package com.DCStudios.AppProjectXXX.Background;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Ground {
	protected Vector2 position;
	protected Measure measure;

	protected Texture texture;
	protected Sprite sprite;


	public Ground(Vector2 position, Measure measure, Texture texture) {
		this.position = position;
		this.measure = measure;
		this.texture = texture;
		setUpSprite();
	}

	protected void setUpSprite() {
		sprite = new Sprite(texture);
		sprite.setPosition(position.x, position.y);
		sprite.setSize(measure.width, measure.height);
		sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	public void dispose() {
		texture.dispose();
	}

}
