package com.DCStudios.AppProjectXXX.GameObjects;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Mode.Mode;
import com.DCStudios.AppProjectXXX.Object.GameObject;
import com.DCStudios.AppProjectXXX.Resources.Resources;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Gate extends GameObject {

	public Gate(Vector2 position, Measure measure) {
		super(Resources.get(Resources.OBJECT_GATE_ICE, Texture.class), position, measure);
		changeMode(Mode.FIRE);
	}

	@Override
	protected void setUpBody() {
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(position.x + measure.width / 3, position.y + measure.height / 3);
		
		body = world.createBody(bodyDef);
		
		shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(measure.width / 4, measure.height / 2);
		
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
			setTexture(Resources.get(Resources.OBJECT_GATE_ICE, Texture.class));
		} else {
			setTexture(Resources.get(Resources.OBJECT_GATE_FIRE, Texture.class));
		}
	}

}
