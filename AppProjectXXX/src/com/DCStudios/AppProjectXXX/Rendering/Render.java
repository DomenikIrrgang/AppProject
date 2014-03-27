package com.DCStudios.AppProjectXXX.Rendering;

import java.util.Iterator;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Map.MapInterface;
import com.DCStudios.AppProjectXXX.Math.MyMath;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Array;

public class Render {

	private MapInterface map;

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private OrthographicCamera testCamera;

	public boolean renderLight = false;
	public boolean renderBackground = true;
	public boolean renderPhysic = false;

	private Box2DDebugRenderer box2DRenderer;

	private Measure measure;
	private float zoom = 10f;

	public Render(MapInterface map) {
		this.map = map;

		box2DRenderer = new Box2DDebugRenderer();
		

		measure = new Measure(Gdx.graphics.getWidth() / zoom,
				Gdx.graphics.getHeight() / zoom);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, measure.width, measure.height);
		camera.update();

		testCamera = new OrthographicCamera();
		testCamera.setToOrtho(false, measure.width * 8, measure.height * 8);
		testCamera.update();

		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);

		map.step();
		updateCameraSettings();
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
			LightRender.render(camera);
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
		Iterator<Drawable> graphics = getDrawableInView(drawables).iterator();
		Drawable graphic;

		while (graphics.hasNext()) {
			graphic = graphics.next();
			graphic.draw(batch);
		}
	}

	private Array<Drawable> getDrawableInView(DrawableCollection drawables) {
		Vector2 position = new Vector2(camera.position.x, camera.position.y);
		Measure measure = new Measure(camera.viewportWidth,
				camera.viewportHeight);

		Array<Drawable> temp = new Array<Drawable>();
		Iterator<Drawable> eIter = drawables.getDrawables().iterator();
		Drawable drawable;

		while (eIter.hasNext()) {
			drawable = eIter.next();
			if (MyMath.fitsIn(position, measure, drawable.getPosition(),
					drawable.getMeasure())) {
				temp.add(drawable);
			}
		}

		return temp;
	}

	private void updateCameraSettings() {
		camera.position.set(map.getPlayer().getBody().getPosition().x
				+ map.getPlayer().getMeasure().width / 2, map.getPlayer()
				.getBody().getPosition().y
				+ map.getPlayer().getMeasure().height / 2, 0);
		
		camera.update();

	}

	public void dispose() {
		box2DRenderer.dispose();
		batch.dispose();
	}
}
