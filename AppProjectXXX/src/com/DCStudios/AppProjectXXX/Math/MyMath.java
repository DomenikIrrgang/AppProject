package com.DCStudios.AppProjectXXX.Math;

import com.DCStudios.AppProjectXXX.Datastructures.Measure;
import com.badlogic.gdx.math.Vector2;

public class MyMath {
	public static boolean fitsIn(Vector2 position1, Measure measure1,
			Vector2 position2, Measure measure2) {
		if (position2.x - measure2.width / 2 >= position1.x - measure1.width / 2 - 5f &&
			position2.x + measure2.width / 2 <= position1.x + measure1.width / 2 + 5f &&
			position2.y + measure2.height / 2 <= position1.y + measure1.height / 2 + 5f &&
			position2.y - measure2.height / 2 >= position1.y - measure1.height - 5f) {
			return true;
		}
		return false;
	}
}
