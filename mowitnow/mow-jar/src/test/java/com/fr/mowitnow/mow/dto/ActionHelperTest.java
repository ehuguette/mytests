package com.fr.mowitnow.mow.dto;

import org.junit.Assert;
import org.junit.Test;

import com.fr.mowitnow.mow.DataGenerator;
import com.fr.mowitnow.mow.constant.EnumDirection;

/**
 * {@link ActionHelper} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class ActionHelperTest {

	/**
	 * Test for method {@link ActionHelper#next(EnumDirection)}.
	 */
	@Test
	public void testNextNorth() {
		final EnumDirection direction = ActionHelper.next(EnumDirection.N);

		Assert.assertEquals(EnumDirection.W, direction);
	}

	/**
	 * Test for method {@link ActionHelper#next(EnumDirection)}.
	 */
	@Test
	public void testNextWest() {
		final EnumDirection direction = ActionHelper.next(EnumDirection.W);

		Assert.assertEquals(EnumDirection.S, direction);
	}

	/**
	 * Test for method {@link ActionHelper#next(EnumDirection)}.
	 */
	@Test
	public void testNextSouth() {
		final EnumDirection direction = ActionHelper.next(EnumDirection.S);

		Assert.assertEquals(EnumDirection.E, direction);
	}

	/**
	 * Test for method {@link ActionHelper#next(EnumDirection)}.
	 */
	@Test
	public void testNextEst() {
		final EnumDirection direction = ActionHelper.next(EnumDirection.E);

		Assert.assertEquals(EnumDirection.N, direction);
	}

	/**
	 * Test for method {@link ActionHelper#next(EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testNextNull() {
		ActionHelper.next(null);
	}

	/**
	 * Test for method {@link ActionHelper#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousNorth() {
		final EnumDirection direction = ActionHelper.previous(EnumDirection.N);
		Assert.assertEquals(EnumDirection.E, direction);
	}

	/**
	 * Test for method {@link ActionHelper#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousWest() {
		final EnumDirection direction = ActionHelper.previous(EnumDirection.W);
		Assert.assertEquals(EnumDirection.N, direction);
	}

	/**
	 * Test for method {@link ActionHelper#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousSouth() {
		final EnumDirection direction = ActionHelper.previous(EnumDirection.S);
		Assert.assertEquals(EnumDirection.W, direction);
	}

	/**
	 * Test for method {@link ActionHelper#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousEst() {
		final EnumDirection direction = ActionHelper.previous(EnumDirection.E);
		Assert.assertEquals(EnumDirection.S, direction);
	}

	/**
	 * Test for method {@link ActionHelper#previous(EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testPreviousNull() {
		ActionHelper.previous(null);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveNorth() {
		final Coordinates resultCoordinates = new Coordinates(1, 3);
		final Coordinates coordinates = ActionHelper.moveOneStep(
				new Coordinates(1, 2), EnumDirection.N);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveWest() {
		final Coordinates resultCoordinates = new Coordinates(2, 2);
		final Coordinates coordinates = ActionHelper.moveOneStep(
				new Coordinates(1, 2), EnumDirection.W);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveSouth() {
		final Coordinates resultCoordinates = new Coordinates(1, 1);
		final Coordinates coordinates = ActionHelper.moveOneStep(
				new Coordinates(1, 2), EnumDirection.S);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveEst() {
		final Coordinates resultCoordinates = new Coordinates(0, 2);
		final Coordinates coordinates = ActionHelper.moveOneStep(
				new Coordinates(1, 2), EnumDirection.E);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMoveWithNullCoordinates() {
		ActionHelper.moveOneStep(null, EnumDirection.E);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMoveWithNullDirection() {
		ActionHelper.moveOneStep(new Coordinates(1, 2), null);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinates() {
		final Coordinates resultCoordinates = new Coordinates(5, 5);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = ActionHelper.isInFieldCoordinates(mowField,
				resultCoordinates);

		Assert.assertEquals(Boolean.TRUE, isInField);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesNorthFalse() {
		final Coordinates resultCoordinates = new Coordinates(6, 4);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = ActionHelper.isInFieldCoordinates(mowField,
				resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesWestFalse() {
		final Coordinates resultCoordinates = new Coordinates(4, 6);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = ActionHelper.isInFieldCoordinates(mowField,
				resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesSouthFalse() {
		final Coordinates resultCoordinates = new Coordinates(-1, 0);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = ActionHelper.isInFieldCoordinates(mowField,
				resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesEstFalse() {
		final Coordinates resultCoordinates = new Coordinates(0, -1);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = ActionHelper.isInFieldCoordinates(mowField,
				resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testIsInFieldCoordinatesWithNullField() {
		final Coordinates resultCoordinates = new Coordinates(2, 2);
		ActionHelper.isInFieldCoordinates(null, resultCoordinates);
	}

	/**
	 * Test for method
	 * {@link ActionHelper#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testIsInFieldCoordinatesWithNullCoordinates() {
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		ActionHelper.isInFieldCoordinates(mowField, null);
	}

}
