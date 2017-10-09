/**
 * 
 */
package com.robogame.command;

import com.robogame.exception.CustomException;
import com.robogame.setup.PositionSetup;
import com.robogame.util.GameConstants;
import com.robogame.util.LattLongData;
import com.robogame.validator.PositionValidator;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class PlacePosition implements Position{
	
	@Override
	public boolean executeCommand(String inputCmd,PositionSetup positionSetup) throws CustomException {
		PositionValidator posValidator = new PositionValidator();
		posValidator.validatePlace(inputCmd);
		String[] inputVals = inputCmd.split(GameConstants.COMA);
		positionSetup.setPosition(inputCmd, new LattLongData(Integer.parseInt(inputVals[GameConstants.ZERO]), Integer.parseInt(inputVals[GameConstants.ONE])));
		posValidator.validateCoordinates(positionSetup);
		return true;
	}

}
