package com.DCStudios.AppProjectXXX.Background;

import java.util.Iterator;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Math.MyMath;
import com.DCStudios.AppProjectXXX.Rendering.Drawable;
import com.DCStudios.AppProjectXXX.Rendering.DrawableCollection;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public abstract class BackGround implements DrawableCollection {
	protected Array<Drawable> backGround = new Array<Drawable>();
	
	public BackGround(){
		setUpBackGround();
	}
	
	public void moveBackGround(Vector2 direction) {
		Iterator<Drawable> gIter = backGround.iterator();
		Drawable ground;
		while (gIter.hasNext()) {
			ground = gIter.next();
			ground.getPosition().scl(direction);
		}
	}
	
	protected abstract void setUpBackGround();
	
	public void draw(SpriteBatch batch) {
		Iterator<Drawable> gIter = backGround.iterator();
		Drawable ground;
		while (gIter.hasNext()) {
			ground = gIter.next();
			ground.draw(batch);
		}
	}
	
	@Override
	public Array<Drawable> getDrawables() {
		return backGround;
	}
	
	public void dispose() {
		Iterator<Drawable> gIter = backGround.iterator();
		Ground ground;
		while (gIter.hasNext()) {
			ground = (Ground) gIter.next();
			ground.dispose();
		}
	}
	
}
