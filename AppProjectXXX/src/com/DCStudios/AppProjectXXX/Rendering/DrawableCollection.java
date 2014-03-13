package com.DCStudios.AppProjectXXX.Rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;

public interface DrawableCollection {
	Array<Drawable> getDrawablesInView(OrthographicCamera camera);
}
