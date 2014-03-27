package com.DCStudios.AppProjectXXX.Player;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Mode.Mode;
import com.DCStudios.AppProjectXXX.Mode.CanModeChange;
import com.DCStudios.AppProjectXXX.Object.Collectable;
import com.DCStudios.AppProjectXXX.Object.GameObject;
import com.DCStudios.AppProjectXXX.Object.CanCollect;
import com.DCStudios.AppProjectXXX.Resources.Resources;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Player extends GameObject implements PlayerInterface, CanModeChange, CanCollect {

	private float speed = 40;
	private Vector2 velocity = new Vector2(1,0);
	
	private boolean alive = true;
	private int points = 0;
	
	public Player(Vector2 position, Measure measure) {
		super(Resources.get(Resources.TREE, Texture.class), position, measure);	
		changeMode(Mode.ICE);
	}

	public void setVelocity(int x, int y) {
		this.velocity.x = x;
		this.velocity.y = y;
	}

	@Override
	protected void setUpBody() {
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x + measure.width / 2, position.y + measure.height / 2);
		
		body = this.world.createBody(bodyDef);
		
		shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(measure.width / 2, measure.height / 2);
		
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
		body.setLinearVelocity(velocity.x * speed, velocity.y * speed);
		//body.applyForceToCenter(new Vector2(velocity.x * speed, velocity.y * speed), true);			
	}
	
	@Override
	protected void changeTexture(Mode mode) {
		if (mode.equals(Mode.ICE)) {
			setTexture(Resources.get(Resources.PLAYER_ICE, Texture.class));
		} else {
			setTexture(Resources.get(Resources.PLAYER_FIRE, Texture.class));
		}
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}

	@Override
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public void addValue(int value) {
		points += value;
		Gdx.app.log("points", String.valueOf(points));
	}

	

}
