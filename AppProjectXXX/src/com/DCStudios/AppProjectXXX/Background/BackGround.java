package com.DCStudios.AppProjectXXX.Background;

import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public abstract class BackGround {
	Array<Ground> backGround = new Array<Ground>();
	
	public BackGround(){
		setUpBackGround();
	}
	
	public void moveBackGround(Vector2 direction) {
		Iterator<Ground> gIter = backGround.iterator();
		Ground ground;
		while (gIter.hasNext()) {
			ground = gIter.next();
			ground.getPosition().scl(direction);
		}
	}
	
	protected abstract void setUpBackGround();
	
	public void draw(SpriteBatch batch) {
		Iterator<Ground> gIter = backGround.iterator();
		Ground ground;
		while (gIter.hasNext()) {
			ground = gIter.next();
			ground.draw(batch);
		}
	}
	
	public void dispose() {
		Iterator<Ground> gIter = backGround.iterator();
		Ground ground;
		while (gIter.hasNext()) {
			ground = gIter.next();
			ground.dispose();
		}
	}
	
}
