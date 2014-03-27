package com.DCStudios.AppProjectXXX.Object;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Entity.Entity;
import com.DCStudios.AppProjectXXX.Mode.Mode;
import com.DCStudios.AppProjectXXX.Mode.CanModeChange;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject extends Entity implements CanModeChange {

	private Mode mode;
	
	public GameObject(Texture texture, Vector2 position, Measure measure) {
		super(texture, position, measure);
		changeMode(Mode.FIRE);
	}

	@Override
	protected abstract void setUpBody();
	protected abstract void changeTexture(Mode mode);

	@Override
	public void changeMode(Mode mode) {
		this.mode = mode;
		changeTexture(mode);
	}

	@Override
	public void changeMode() {
		mode = Mode.changeMode(mode);
		changeTexture(mode);
	}

	@Override
	public Mode getMode() {
		return mode;
	}

}
