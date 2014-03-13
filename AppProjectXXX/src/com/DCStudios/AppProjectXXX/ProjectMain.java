package com.DCStudios.AppProjectXXX;

import com.DCStudios.AppProjectXXX.Resources.Resources;
import com.DCStudios.AppProjectXXX.Screens.GameScreen;
import com.badlogic.gdx.Game;

public class ProjectMain extends Game {
	public static final String name = "ProjectXXX";
	public static final String version = "0.0.0.06 Pre-Alpha";
	
	@Override
	public void create() {		
		Resources.load();
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
