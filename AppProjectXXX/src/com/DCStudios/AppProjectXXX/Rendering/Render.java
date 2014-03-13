package com.DCStudios.AppProjectXXX.Rendering;

import java.util.Iterator;

import box2dLight.RayHandler;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Entity.Entity;
import com.DCStudios.AppProjectXXX.Map.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class Render {
	
	private Map map;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private OrthographicCamera testCamera;
	
	public boolean renderLight = true;
	public boolean renderBackground = true;
	public boolean renderPhysic = false;
	
	private Box2DDebugRenderer box2DRenderer;
	
	private Measure measure;
	private float zoom = 8f;

	
	public Render(Map map) {
		this.map = map;
		
		box2DRenderer = new Box2DDebugRenderer();
		
		measure = new Measure(Gdx.graphics.getWidth() / zoom,
				Gdx.graphics.getHeight() / zoom);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, measure.width, measure.height);
		camera.update();
		
		testCamera = new OrthographicCamera();
		testCamera.setToOrtho(false, measure.width * 6, measure.height * 6);
		testCamera.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
	}
	
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		
		map.step();
		batch.begin();
		renderBackground();
		batch.end();
		
		renderPhysic();
		
		batch.begin();
		renderGraphics();
		batch.end();
		renderLight();
	}
	
	private void renderLight() {
		if (renderLight) {
			LightRender.getRayHandler().setCombinedMatrix(camera.combined);
			LightRender.getRayHandler().updateAndRender();
		}
	}
	private void renderBackground() {
		if (renderBackground) {
			renderDrawablesInView(map.getBackground());
		}
	}
	
	private void renderPhysic() {
		if (renderPhysic) {
			box2DRenderer.render(map.getWorld(), camera.combined);
		}
	}
	
	private void renderGraphics() {
		renderDrawablesInView(map);
	}
	
	private void renderDrawablesInView(DrawableCollection drawables) {
		Iterator<Drawable> graphics = drawables.getDrawablesInView(camera).iterator();
		Drawable graphic;
		
		while (graphics.hasNext()) {
			graphic = graphics.next();
			graphic.draw(batch);
		}
	}
	
	public void dispose() {
		box2DRenderer.dispose();
		batch.dispose();
	}
}
