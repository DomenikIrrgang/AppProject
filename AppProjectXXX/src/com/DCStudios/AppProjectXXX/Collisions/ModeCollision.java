package com.DCStudios.AppProjectXXX.Collisions;

import com.DCStudios.AppProjectXXX.Collision.CollisionHandler;
import com.DCStudios.AppProjectXXX.Mode.CanModeChange;
import com.DCStudios.AppProjectXXX.Player.Player;
import com.badlogic.gdx.physics.box2d.Contact;

public class ModeCollision implements CollisionHandler {

	@Override
	public void startCollision(Contact contact) {
		if (contact.getFixtureA().getBody().getUserData() instanceof CanModeChange &&
				contact.getFixtureB().getBody().getUserData() instanceof Player) {
			if (!((Player)contact.getFixtureB().getBody().getUserData()).getMode().equals(((CanModeChange)contact.getFixtureA().getBody().getUserData()).getMode())) {
				((Player)contact.getFixtureB().getBody().getUserData()).setAlive(false);
			}		
		} else {
			if (contact.getFixtureA().getBody().getUserData() instanceof Player &&
					contact.getFixtureB().getBody().getUserData() instanceof CanModeChange) {
					if (!((Player)contact.getFixtureA().getBody().getUserData()).getMode().equals(((CanModeChange)contact.getFixtureB().getBody().getUserData()).getMode())) {
						((Player)contact.getFixtureA().getBody().getUserData()).setAlive(false);
					}
			}
		}
	}

	@Override
	public void endCollision(Contact contact) {
		if (contact.getFixtureA().getBody().getUserData() instanceof CanModeChange &&
				contact.getFixtureB().getBody().getUserData() instanceof Player) {
			((CanModeChange) contact.getFixtureA().getBody().getUserData()).changeMode();		
		} else {
			if (contact.getFixtureA().getBody().getUserData() instanceof Player &&
					contact.getFixtureB().getBody().getUserData() instanceof CanModeChange) {
				((CanModeChange) contact.getFixtureB().getBody().getUserData()).changeMode();	
			}
		}
	}

}
