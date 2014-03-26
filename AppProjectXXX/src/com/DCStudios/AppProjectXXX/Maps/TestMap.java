package com.DCStudios.AppProjectXXX.Maps;

import box2dLight.Light;
import box2dLight.PointLight;

import com.DCStudios.AppProjectXXX.Backgrounds.TestBackGround;
import com.DCStudios.AppProjectXXX.Collisions.ModeCollision;
import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.GameObjects.Gate;
import com.DCStudios.AppProjectXXX.Map.Map;
import com.DCStudios.AppProjectXXX.Player.Player;
import com.DCStudios.AppProjectXXX.Rendering.LightRender;
import com.DCStudios.AppProjectXXX.Screens.GameScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class TestMap extends Map {

	public TestMap(GameScreen screen) {
		super(screen);
		Light light = new PointLight(LightRender.getRayHandler(), 200, new Color(0.5f, 0.3f, 0.6f, 1f), 20f, 25f, 25f);
		setUpMapBounds(new Measure(1000,100));
		background = new TestBackGround();
		Gate gate = new Gate(new Vector2(100,43), new Measure(2,66));
		addEntity(gate);
		gate = new Gate(new Vector2(150,43), new Measure(2,66));
		gate.changeMode();
		addEntity(gate);
		gate = new Gate(new Vector2(200,43), new Measure(2,66));
		addEntity(gate);
		collisionListener.addCollision(new ModeCollision());
	}

	@Override
	public void setUpPlayer() {
		player = new Player(new Vector2(50,50), new Measure(7,7));
		addEntity(player);
	}
	
	@Override
	public void update() {
		super.update();
		if (!getPlayer().isAlive()) {
			screen.setNewWorld(new TestMap(screen));
		}
	}

}
