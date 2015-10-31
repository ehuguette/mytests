package com.fr.mowitnow.mow.framework;

import com.fr.mowitnow.mow.dto.MowFieldParameters;
import com.fr.mowitnow.mow.dto.MowPosition;

/**
 * Implementation of action to turn right.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionTurnRight implements IMowAction {

	@Override
	public void executeAction(MowFieldParameters mowFieldParameters) {
		MowPosition mowPosition = mowFieldParameters.getMowPosition();
		mowPosition.turnRight();
	}

}
