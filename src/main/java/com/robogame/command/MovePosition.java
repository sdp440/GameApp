/**
 * 
 */
package com.robogame.command;

import com.robogame.exception.CustomException;
import com.robogame.setup.PositionSetup;
import com.robogame.util.GameConstants;
import com.robogame.validator.PositionValidator;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class MovePosition implements Position{
	
	@Override
	public boolean executeCommand(String inputCmd,PositionSetup positionSetup) throws CustomException {
		PositionValidator posValidator = new PositionValidator();
		posValidator.validateInputCommand(positionSetup);
		boolean toContinue =true;
		switch (positionSetup.getDirectionFacing()) {
		case NORTH:
			positionSetup.setCordinates(positionSetup.getCordinates().changePoint(GameConstants.ZERO, GameConstants.ONE));
			break;
		case EAST:
			positionSetup.setCordinates(positionSetup.getCordinates().changePoint(GameConstants.ONE, GameConstants.ZERO));
			break;
		case SOUTH:
			positionSetup.setCordinates(positionSetup.getCordinates().changePoint(0, GameConstants.MINUS_ONE));
			break;
		case WEST:
			positionSetup.setCordinates(positionSetup.getCordinates().changePoint(GameConstants.MINUS_ONE, GameConstants.ZERO));
			break;
		default :
			toContinue =false;
		}
		posValidator.validateCoordinates(positionSetup);
		return toContinue;
	}

}
