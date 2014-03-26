package com.DCStudios.AppProjectXXX.Resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public final class Resources {
	private static AssetManager manager;
	
	public static final String path = "data/";	
	public static final String GRASS = path + "grass.jpg";
	public static final String BACKGROUND_STAR = path + "star_background.png";
	public static final String TREE = path + "baum.png";
	public static final String PLAYER_FIRE = path + "fire.png";
	public static final String PLAYER_ICE = path + "ice.png";
	public static final String OBJECT_GATE_FIRE = path + "gate_fire.png";
	public static final String OBJECT_GATE_ICE = path + "gate_ice.png";
	
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
		manager.load(PLAYER_FIRE, Texture.class, parameter);
		manager.load(PLAYER_ICE, Texture.class, parameter);
		manager.load(OBJECT_GATE_ICE, Texture.class, parameter);
		manager.load(OBJECT_GATE_FIRE, Texture.class, parameter);
		manager.load(BACKGROUND_STAR, Texture.class, parameter);
	}
}
