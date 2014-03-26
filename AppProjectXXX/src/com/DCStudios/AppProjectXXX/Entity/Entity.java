package com.DCStudios.AppProjectXXX.Entity;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Rendering.Drawable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Entity implements Drawable {

	protected Vector2 position;
	protected Measure measure;

	protected Texture texture;
	protected Sprite sprite;

	protected World world;
	protected Body body;
	protected BodyDef bodyDef;
	protected FixtureDef fixtureDef;
	protected Shape shape;

	public Entity(Texture texture, Vector2 position, Measure measure) {
		this.texture = texture;
		this.position = position;
		this.measure = measure;
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		sprite.setSize(measure.width, measure.height);
		sprite.setPosition(position.x, position.y);
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

	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
		sprite.setTexture(this.texture);
	}

	public Sprite getSprite() {
		return sprite;
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}

	public void update() {
		sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2,
				body.getPosition().y - sprite.getHeight() / 2);
		sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);

		position.x = sprite.getX();
		position.y = sprite.getY();
	}

	public Body getBody() {
		return body;
	}

	public void dispose() {
		texture.dispose();
		shape.dispose();
	}

	public void setWorld(World world) {
		this.world = world;
		setUpBody();
	}

	abstract protected void setUpBody();
}
