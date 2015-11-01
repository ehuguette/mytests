package com.fr.mowitnow.mow.dto;

import com.fr.mowitnow.mow.constant.EnumDirection;

/**
 * Implementation of the mow position.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowPosition {

	/** The mow coordinates on the field. */
	private Coordinates coordinates;
	/** The mow orientation. */
	private EnumDirection direction;
	/** The mow action generic operations. */
	private MowActionOperation mowActionOperation;

	/**
	 * Constructor.
	 * 
	 * @param xi
	 *            The top right X limit parameter
	 * @param yi
	 *            The top right X limit parameter
	 * @param direction
	 *            The orientation
	 */
	public MowPosition(Integer xi, Integer yi, EnumDirection direction) {
		this.coordinates = new Coordinates(xi, yi);
		this.direction = direction;
		this.mowActionOperation = new MowActionOperation();
	}

	/**
	 * 
	 * @return {@link Integer} the position of the mow on the X axe
	 */
	public Integer getX() {
		return coordinates.getX();
	}

	/**
	 * 
	 * @return {@link Integer} the position of the mow on the Y axe
	 */
	public Integer getY() {
		return coordinates.getY();
	}

	/**
	 * 
	 * @return {@link EnumDirection}
	 */
	public EnumDirection getDirection() {
		return direction;
	}

	/**
	 * Turn the mow to the next right direction.
	 */
	public void turnRight() {
		this.direction = mowActionOperation.next(this.direction);
	}

	/**
	 * Turn the mow to the next left direction.
	 */
	public void turnLeft() {
		this.direction = mowActionOperation.previous(this.direction);
	}

	/**
	 * Move the mow to next position.
	 * 
	 * @param mowField
	 *            The mow field
	 */
	public void moveOneStep(MowField mowField) {
		Coordinates coordinates = mowActionOperation
				.moveOneStep(this.coordinates, direction);
		if (mowActionOperation.isInFieldCoordinates(mowField, coordinates)) {
			this.coordinates = coordinates;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MowPosition other = (MowPosition) obj;
		if (coordinates == null) {
			if (other.coordinates != null) {
				return false;
			}
		} else if (!coordinates.equals(other.coordinates)) {
			return false;
		}
		if (direction != other.direction) {
			return false;
		}
		return true;
	}

}
