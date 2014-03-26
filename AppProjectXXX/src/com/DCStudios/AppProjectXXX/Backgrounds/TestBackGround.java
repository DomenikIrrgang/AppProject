package com.DCStudios.AppProjectXXX.Backgrounds;

import com.DCStudios.AppProjectXXX.Background.BackGround;
import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Grounds.Grass;
import com.badlogic.gdx.math.Vector2;

public class TestBackGround extends BackGround {

	@Override
	protected void setUpBackGround() {
		for (int i = -50; i < 100; i++)
			for (int k = -50; k < 100; k++)
				backGround.add(new Grass(new Vector2((i-1) * 5, (k-1) * 5), new Measure(20,20)));
	}

}
