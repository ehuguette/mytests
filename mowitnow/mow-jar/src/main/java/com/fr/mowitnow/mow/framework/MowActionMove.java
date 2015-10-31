package com.fr.mowitnow.mow.framework;

import com.fr.mowitnow.mow.dto.MowFieldParameters;
import com.fr.mowitnow.mow.dto.MowPosition;
/**
 * Implement of Action move.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionMove implements IMowAction {

	@Override
	public void executeAction(MowFieldParameters mowFieldParameters) {
		MowPosition mowPosition = mowFieldParameters.getMowPosition();
		mowPosition.moveOneStep(mowFieldParameters.getMowField());
	}

}
