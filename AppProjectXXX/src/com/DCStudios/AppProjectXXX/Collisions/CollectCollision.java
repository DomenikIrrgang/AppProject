package com.DCStudios.AppProjectXXX.Collisions;

import com.DCStudios.AppProjectXXX.Collision.CollisionHandler;
import com.DCStudios.AppProjectXXX.Mode.CanModeChange;
import com.DCStudios.AppProjectXXX.Object.CanCollect;
import com.DCStudios.AppProjectXXX.Object.Collectable;
import com.DCStudios.AppProjectXXX.Player.Player;
import com.badlogic.gdx.physics.box2d.Contact;

public class CollectCollision implements CollisionHandler {

	@Override
	public void startCollision(Contact contact) {
		if (contact.getFixtureA().getBody().getUserData() instanceof Collectable &&
				contact.getFixtureB().getBody().getUserData() instanceof CanCollect) {
			((Collectable) contact.getFixtureA().getBody().getUserData()).collect((CanCollect) contact.getFixtureB().getBody().getUserData());
		} else {
			if (contact.getFixtureA().getBody().getUserData() instanceof CanCollect &&
					contact.getFixtureB().getBody().getUserData() instanceof Collectable) {
				((Collectable) contact.getFixtureB().getBody().getUserData()).collect((CanCollect) contact.getFixtureA().getBody().getUserData());
			}
		}
	}

	@Override
	public void endCollision(Contact contact) {
	}

}
