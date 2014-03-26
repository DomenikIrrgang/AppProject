package com.DCStudios.AppProjectXXX.Mode;

public enum Mode {
	FIRE, ICE;
	
	public static Mode changeMode(Mode mode) {
		if (mode.equals(Mode.ICE)) {
			return Mode.FIRE;
		} else {
			return Mode.ICE;
		}
	}
}
