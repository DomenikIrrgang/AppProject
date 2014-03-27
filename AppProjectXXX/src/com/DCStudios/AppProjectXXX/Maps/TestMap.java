package com.DCStudios.AppProjectXXX.Maps;

import com.DCStudios.AppProjectXXX.Backgrounds.TestBackGround;
import com.DCStudios.AppProjectXXX.Collisions.CollectCollision;
import com.DCStudios.AppProjectXXX.Collisions.ModeCollision;
import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.GameObjects.Ball;
import com.DCStudios.AppProjectXXX.GameObjects.Gate;
import com.DCStudios.AppProjectXXX.Map.Map;
import com.DCStudios.AppProjectXXX.Player.Player;
import com.DCStudios.AppProjectXXX.Screens.GameScreen;
import com.badlogic.gdx.math.Vector2;

public class TestMap extends Map {

	public TestMap(GameScreen screen) {
		super(screen);
		setUpMapBounds(new Measure(1000,100));
		background = new TestBackGround();
		Gate gate = new Gate(new Vector2(100,42), new Measure(2,13));
		addEntity(gate);
		setUpBalls(gate);
		gate = new Gate(new Vector2(150,12), new Measure(2,13));
		gate.changeMode();
		addEntity(gate);
		setUpBalls(gate);
		gate = new Gate(new Vector2(200,42), new Measure(2,13));
		addEntity(gate);
		setUpBalls(gate);
		
		collisionListener.addCollision(new ModeCollision());
		collisionListener.addCollision(new CollectCollision());
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
	
	private void setUpBalls(Gate gate) {
		Ball ball;
		boolean blue = true;
		for (int i = 100; i >= gate.getPosition().y + gate.getMeasure().height - 4; i -= 3) {
			ball = new Ball(new Vector2(gate.getPosition().x - 1,i), new Measure(3,3), 10);
			if (blue) {
				blue = false;
				ball.changeMode();
			} else {
				blue = true;
			}
			addEntity(ball);
		}
		
		for (int i = (int) gate.getPosition().y - 4 ; i >= 0; i -= 3) {
			ball = new Ball(new Vector2(gate.getPosition().x - 1,i), new Measure(3,3), 10);
			if (blue) {
				blue = false;
				ball.changeMode();
			} else {
				blue = true;
			}
			addEntity(ball);
		}

	}

}
