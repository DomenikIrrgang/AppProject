package com.DCStudios.AppProjectXXX.Screens;


import com.DCStudios.AppProjectXXX.ProjectMain;
import com.DCStudios.AppProjectXXX.Controls.InputHandler;
import com.DCStudios.AppProjectXXX.Map.Map;
import com.DCStudios.AppProjectXXX.Maps.TestMap;
import com.DCStudios.AppProjectXXX.Rendering.Render;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;

public class GameScreen implements Screen {

	ProjectMain game;
	Map map;
	Render render;
	InputProcessor input;
	FPSLogger log = new FPSLogger();
	
	public GameScreen(ProjectMain game) {
		this.game = game;
		this.map = new TestMap(this);
		this.render = new Render(map);
		input = new InputHandler(map);
		Gdx.input.setInputProcessor(input);
	}
	
	public void setNewWorld(Map map) {
		this.map = map;
		this.render = new Render(this.map);
		input = new InputHandler(this.map);
		Gdx.input.setInputProcessor(input);
	}
	
	@Override
	public void render(float delta) {
		render.render();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
