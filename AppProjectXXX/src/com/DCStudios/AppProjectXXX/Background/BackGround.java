package com.DCStudios.AppProjectXXX.Background;

import java.util.Iterator;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Rendering.Drawable;
import com.DCStudios.AppProjectXXX.Rendering.DrawableCollection;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public abstract class BackGround implements DrawableCollection {
	protected Array<Ground> backGround = new Array<Ground>();
	
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
	
	public Array<Drawable> getDrawablesInView(OrthographicCamera camera) {
		Vector2 position = new Vector2(camera.position.x, camera.position.y);
		Measure measure = new Measure(camera.viewportWidth, camera.viewportHeight);
		
		float borderLeft = position.x - measure.width / 2 - 5f;
		float borderRight = position.x + measure.width /2 + 5f;
		float borderTop = position.y + measure.height / 2 + 5f;
		float borderBottom = position.y - measure.height / 2 - 5f;
		
		Array<Drawable> temp = new Array<Drawable>();
		Iterator<Ground> eIter = backGround.iterator();
		Ground ground;
		
		while (eIter.hasNext()) {
			ground = eIter.next();
			if (ground.getPosition().x + ground.getMeasure().width / 2 >= borderLeft &&
				ground.getPosition().x - ground.getMeasure().width / 2 <= borderRight &&
				ground.getPosition().y - ground.getMeasure().height / 2 <= borderTop &&
				ground.getPosition().y + ground.getMeasure().height / 2 >= borderBottom) {
				temp.add(ground);
			}
		}
		
		return temp;

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
