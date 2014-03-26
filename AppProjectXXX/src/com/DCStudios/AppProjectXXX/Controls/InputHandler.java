package com.DCStudios.AppProjectXXX.Controls;

import com.DCStudios.AppProjectXXX.Map.Map;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
	
	Map map;
	
	public InputHandler(Map map) {
		this.map = map;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.W: 
			map.getPlayer().setVelocity(1,1);
			return true;
		case Keys.S:
			map.getPlayer().setVelocity(1, -1);
			return true;
		case Keys.SPACE:
			map.getPlayer().changeMode();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.W: 
			map.getPlayer().setVelocity(1,0);
			return true;
		case Keys.S:
			map.getPlayer().setVelocity(1,0);
			return true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (screenX < Gdx.graphics.getWidth() / 2) {
			if (screenY < Gdx.graphics.getHeight() / 2) {
				map.getPlayer().setVelocity(1, 1);
			} else {
				map.getPlayer().setVelocity(1, -1);
			}
			return true;
		} else {
			map.getPlayer().changeMode();
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (screenX < Gdx.graphics.getWidth() / 2) {
			map.getPlayer().setVelocity(1, 0);
			return true;
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
