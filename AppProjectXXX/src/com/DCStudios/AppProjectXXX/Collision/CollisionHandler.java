package com.DCStudios.AppProjectXXX.Collision;

import com.badlogic.gdx.physics.box2d.Contact;

public interface CollisionHandler {

	abstract void startCollision(Contact contact);
	abstract void endCollision(Contact contact);
	
}
