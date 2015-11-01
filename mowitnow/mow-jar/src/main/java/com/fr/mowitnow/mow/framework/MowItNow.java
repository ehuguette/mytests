package com.fr.mowitnow.mow.framework;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fr.mowitnow.mow.constant.EnumAction;
import com.fr.mowitnow.mow.dto.Actions;
import com.fr.mowitnow.mow.dto.MowFieldParameters;
import com.fr.mowitnow.mow.dto.MowParameters;
import com.fr.mowitnow.mow.dto.MowPosition;
import com.fr.mowitnow.mow.dto.MowsParameters;
import com.fr.mowitnow.mow.exceptions.ClientMowException;

/**
 * The mow execution.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowItNow {

	/** logger class. */
	private static final Logger LOG = LoggerFactory
			.getLogger(ParameterOperation.class);

	private ParameterOperation parameterOperation;

	/**
	 * Constructor.
	 */
	public MowItNow() {
		parameterOperation = new ParameterOperation();
	}

	/**
	 * Mows actions parameters to apply.
	 * 
	 * @param moveMessage
	 *            The mow message parameters
	 * @return {@link List}<MowPosition>
	 * @throws ClientMowException
	 *             Raised if the message format is invalid
	 */
	public List<MowPosition> move(String moveMessage)
			throws ClientMowException {
		StringBuilder msgLog = new StringBuilder("Initial message - {");
		msgLog.append(moveMessage).append("}");
		LOG.info(msgLog.toString());

		List<MowPosition> mowPositions = new ArrayList<>();

		MowsParameters parameters = parameterOperation
				.getParamaters(moveMessage);

		MowPosition mowPosition = null;
		for (MowParameters mowParameters : parameters.getList()) {
			mowPosition = actions(mowParameters);
			mowPositions.add(mowPosition);

			msgLog = new StringBuilder("Position");
			msgLog.append(" - X = ").append(mowPosition.getX());
			msgLog.append(" - Y = ").append(mowPosition.getY());
			msgLog.append(" - Direction = ").append(mowPosition.getDirection());
			LOG.info(msgLog.toString());
		}
		return mowPositions;
	}

	/**
	 * Apply action on the mow parameters.
	 * 
	 * @param mowParameters
	 *            The mow parameters
	 * @return {@link MowPosition} The mow position
	 */
	protected MowPosition actions(MowParameters mowParameters) {
		MowPosition movePosition = null;
		MowFieldParameters mowFieldParameters = null;
		IMowAction mowAction = null;
		if (mowParameters == null || mowParameters.getMowField() == null
				|| mowParameters.getActions() == null) {
			StringBuilder msgError = new StringBuilder(
					"Parameters should not be null - ");
			msgError.append("fieldParameters is null : ");
			msgError.append(mowParameters == null
					? true
					: mowParameters.getMowField() == null);
			msgError.append(" - ");
			msgError.append("actionParameters is null : ");
			msgError.append(mowParameters == null
					? true
					: mowParameters.getActions() == null);
			msgError.append(" - ");
			msgError.append("mowParameters is null : ")
					.append(mowParameters == null);
			LOG.error(msgError.toString());
			throw new IllegalArgumentException(msgError.toString());
		} else {
			MowPosition initialPosition = mowParameters.getMowPosition();

			// Copy the data original position
			mowFieldParameters = new MowFieldParameters(initialPosition.getX(),
					initialPosition.getY(), initialPosition.getDirection());
			movePosition = mowFieldParameters.getMowPosition();
			mowFieldParameters.setMowField(mowParameters.getMowField());
			Actions actions = mowParameters.getActions();
			StringBuilder msg = null;
			for (EnumAction enumAction : actions.getList()) {
				mowAction = MowActionCache.getInstance()
						.getMowAction(enumAction);
				mowAction.executeAction(mowFieldParameters);
				msg = new StringBuilder("Movement");
				msg.append(" - Action = ").append(enumAction);
				msg.append(" - X = ").append(movePosition.getX());
				msg.append(" - Y = ").append(movePosition.getY());
				msg.append(" - Direction = ")
						.append(movePosition.getDirection());
				LOG.debug(msg.toString());
			}
		}
		return movePosition;
	}
}
