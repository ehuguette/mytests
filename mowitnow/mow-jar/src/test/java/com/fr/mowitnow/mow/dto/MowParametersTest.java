package com.fr.mowitnow.mow.dto;

import org.junit.Assert;
import org.junit.Test;

import com.fr.mowitnow.mow.constant.EnumDirection;

/**
 * {@link MowParameters} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowParametersTest {

	/**
	 * Test for method {@link MowParameters#equals(Object)}.
	 */
	@Test
	public void testEquals() {
		final MowParameters mowParameters1 = new MowParameters(1, 2,
				EnumDirection.N);

		final MowParameters mowParameters2 = new MowParameters(1, 2,
				EnumDirection.N);
		Assert.assertEquals(mowParameters1, mowParameters2);
	}

}
