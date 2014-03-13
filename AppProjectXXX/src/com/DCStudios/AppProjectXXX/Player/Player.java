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

	Mode mode;
	
	public Player(Texture texture, Vector2 position, Measure measure) {
		super(texture, position, measure);	
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
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x + measure.width / 2, position.y + measure.height / 2);
		
		body = this.world.createBody(bodyDef);
		
		shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(measure.width / 2 - 0.5f, measure.height / 2 - 0.5f);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 1.0f;
		fixtureDef.restitution = 0.0f;
		body.setFixedRotation(true);
				
		body.createFixture(fixtureDef); 
		
		sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
		body.setUserData(this);		
	}
	
	@Override
	public void update() {
		super.update();
		//body.applyForceToCenter(new Vector2(), wake);
	}

}