package com.fr.mowitnow.mow.framework;

import com.fr.mowitnow.mow.dto.MowFieldParameters;

/**
 * Interface mow action exposing services.
 * 
 * @author ehuguette
 * @since 1.0
 */
public interface IMowAction {

	/**
	 * Execute action on mow parameters.
	 * 
	 * @param mowParameters
	 *            The mow parameters
	 */
	void executeAction(MowFieldParameters mowParameters);
}
