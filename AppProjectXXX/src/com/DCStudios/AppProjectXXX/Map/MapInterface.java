package com.DCStudios.AppProjectXXX.Map;

import com.DCStudios.AppProjectXXX.Background.BackGround;
import com.DCStudios.AppProjectXXX.Player.Player;
import com.DCStudios.AppProjectXXX.Rendering.DrawableCollection;
import com.badlogic.gdx.physics.box2d.World;

public interface MapInterface extends DrawableCollection {
	void step();
	void update();
	void dispose();
	void setUpPlayer();
	BackGround getBackground();
	World getWorld();
	Player getPlayer();
	
}
