package com.DCStudios.AppProjectXXX.Backgrounds;

import com.DCStudios.AppProjectXXX.Background.BackGround;
import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.DCStudios.AppProjectXXX.Grounds.Grass;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class TestBackGround extends BackGround {

	@Override
	protected void setUpBackGround() {
		for (int i = -50; i < 0; i++)
			for (int k = -50; k < 0; k++)
				backGround.add(new Grass(new Vector2(MathUtils.random(-50, 1000),MathUtils.random(-20, 100)), new Measure(3,3)));
	}

}
//new Vector2((i-1) * 5, (k-1) * 5