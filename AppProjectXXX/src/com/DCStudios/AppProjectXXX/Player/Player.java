package com.DCStudios.AppProjectXXX.Player;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Entity.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Player extends Entity implements PlayerInterface {

	private Mode mode;
	private float speed = 1;
	private Vector2 velocity = new Vector2(1,0);
	
	public Player(Vector2 position, Measure measure) {
		super(new Texture("data/baum.png"), position, measure);	
		mode = Mode.FIRE;
	}
	
	@Override
	public void jump() {
	}

	@Override
	public void switchMode() {
	}

	@Override
	protected void setUpBody() {
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set(position.x + measure.width / 2, position.y + measure.height / 2);
		
		body = this.world.createBody(bodyDef);
		
		shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(measure.width / 2 - 0.5f, measure.height / 2 - 0.5f);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 1.0f;
		body.setFixedRotation(true);
				
		body.createFixture(fixtureDef); 
		
		sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
		body.setUserData(this);		
	}
	
	@Override
	public void update() {
		super.update();
		body.applyForceToCenter(new Vector2(velocity.x * speed, velocity.y * speed), true);	

	}

}
