package com.DCStudios.AppProjectXXX.Collisions;

import com.DCStudios.AppProjectXXX.Collision.CollisionHandler;
import com.DCStudios.AppProjectXXX.Mode.canModeChange;
import com.DCStudios.AppProjectXXX.Player.Player;
import com.badlogic.gdx.physics.box2d.Contact;

public class ModeCollision implements CollisionHandler {

	@Override
	public void startCollision(Contact contact) {
		if (contact.getFixtureA().getBody().getUserData() instanceof canModeChange &&
				contact.getFixtureB().getBody().getUserData() instanceof Player) {
			if (!((Player)contact.getFixtureB().getBody().getUserData()).getMode().equals(((canModeChange)contact.getFixtureA().getBody().getUserData()).getMode())) {
				((Player)contact.getFixtureB().getBody().getUserData()).setAlive(false);
			}		
		} else {
			if (contact.getFixtureA().getBody().getUserData() instanceof Player &&
					contact.getFixtureB().getBody().getUserData() instanceof canModeChange) {
					if (!((Player)contact.getFixtureA().getBody().getUserData()).getMode().equals(((canModeChange)contact.getFixtureB().getBody().getUserData()).getMode())) {
						((Player)contact.getFixtureA().getBody().getUserData()).setAlive(false);
					}
			}
		}
	}

	@Override
	public void endCollision(Contact contact) {
		if (contact.getFixtureA().getBody().getUserData() instanceof canModeChange &&
				contact.getFixtureB().getBody().getUserData() instanceof Player) {
			((canModeChange) contact.getFixtureA().getBody().getUserData()).changeMode();		
		} else {
			if (contact.getFixtureA().getBody().getUserData() instanceof Player &&
					contact.getFixtureB().getBody().getUserData() instanceof canModeChange) {
				((canModeChange) contact.getFixtureB().getBody().getUserData()).changeMode();	
			}
		}
	}

}
