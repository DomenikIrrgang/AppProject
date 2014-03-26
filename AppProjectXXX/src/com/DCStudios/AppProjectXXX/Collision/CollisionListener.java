package com.DCStudios.AppProjectXXX.Collision;

import java.util.Iterator;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.utils.Array;

public class CollisionListener implements ContactListener {
	
	private Array<CollisionHandler> collisionHandler;
	
	private CollisionHandler collision;
	private Iterator<CollisionHandler> cIter;
	
	public CollisionListener() {
		collisionHandler = new Array<CollisionHandler>();
	}
	
	public void addCollision(CollisionHandler collision) {
		collisionHandler.add(collision);
	}

	@Override
	public void beginContact(Contact contact) {
		cIter = collisionHandler.iterator();
		while (cIter.hasNext()) {
			collision = cIter.next();
			collision.startCollision(contact);
		}
	}

	@Override
	public void endContact(Contact contact) {	
		cIter = collisionHandler.iterator();
		while (cIter.hasNext()) {
			collision = cIter.next();
			collision.endCollision(contact);
		}
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
	}

}
