package com.DCStudios.AppProjectXXX.GameObjects;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Mode.Mode;
import com.DCStudios.AppProjectXXX.Object.CanCollect;
import com.DCStudios.AppProjectXXX.Object.Collectable;
import com.DCStudios.AppProjectXXX.Object.GameObject;
import com.DCStudios.AppProjectXXX.Resources.Resources;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Ball extends GameObject implements Collectable {

	private boolean collected = false;
	private int value;
	
	
	public Ball(Vector2 position, Measure measure, int value) {
		super(Resources.get(Resources.OBJECT_BALL_FIRE, Texture.class), position, measure);
		this.value = value;
	}

	@Override
	protected void setUpBody() {
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(position.x + measure.width / 2, position.y + measure.width / 2);
		
		body = world.createBody(bodyDef);
		
		shape = new CircleShape();
		((CircleShape) shape).setRadius(measure.width / 2);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 0.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 0.0f;
		fixtureDef.isSensor = true;
		
		
		body.setFixedRotation(true);
		
		body.createFixture(fixtureDef);
		
		
		body.setUserData(this);	
	}

	@Override
	protected void changeTexture(Mode mode) {
		if (mode.equals(Mode.ICE)) {
			setTexture(Resources.get(Resources.OBJECT_BALL_ICE, Texture.class));
		} else {
			setTexture(Resources.get(Resources.OBJECT_BALL_FIRE, Texture.class));
		}
	}



	@Override
	public void setCollected(boolean collected) {
		this.collected = collected;
	}

	@Override
	public boolean getCollected() {
		return collected;
	}

	@Override
	public void collect(CanCollect canCollect) {
		canCollect.addValue(value);
		visible = false;
	}

}
