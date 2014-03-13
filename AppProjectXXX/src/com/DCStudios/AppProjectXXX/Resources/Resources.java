package com.DCStudios.AppProjectXXX.Resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public final class Resources {
	private static AssetManager manager;
	
	public static final String path = "data/";	
	public static final String GRASS = path + "grass.jpg";
	public static final String TREE = path + "baum.png";
	
	
	public static <T> T get(String id, Class<T> clazz) {
		manager.finishLoading();
		return manager.get(id, clazz);
	}
	
	public static void load() {
		manager = new AssetManager();
		
		TextureParameter parameter = new TextureParameter();
		parameter.minFilter = TextureFilter.Linear;
		parameter.magFilter = TextureFilter.Linear;
		parameter.genMipMaps = true;
		
		manager.load(GRASS, Texture.class, parameter);
		manager.load(TREE, Texture.class, parameter);
	}
}
