package com.fr.mowitnow.mow.framework;

import com.fr.mowitnow.mow.dto.MowFieldParameters;
import com.fr.mowitnow.mow.dto.MowPosition;

/**
 * Implementation of action to turn left.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionTurnLeft implements IMowAction {

	@Override
	public void executeAction(MowFieldParameters mowFieldParameters) {
		MowPosition mowPosition = mowFieldParameters.getMowPosition();
		mowPosition.turnLeft();
	}

}
