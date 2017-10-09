/**
 * 
 */
package com.robogame.command;

import com.robogame.exception.CustomException;
import com.robogame.setup.PositionSetup;
import com.robogame.util.DirectionEnum;
import com.robogame.validator.PositionValidator;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class TurnLeft implements Position {

	@Override
	public boolean executeCommand(String inputCmd, PositionSetup positionSetup) throws CustomException {
		boolean toContinue = true;
		PositionValidator posValidator = new PositionValidator();
		posValidator.validateInputCommand(positionSetup);
		switch (positionSetup.getDirectionFacing()) {
		case NORTH:
			positionSetup.setDirectionFacing(DirectionEnum.WEST);
			break;
		case WEST:
			positionSetup.setDirectionFacing(DirectionEnum.SOUTH);
			break;
		case SOUTH:
			positionSetup.setDirectionFacing(DirectionEnum.EAST);
			break;
		case EAST:
			positionSetup.setDirectionFacing(DirectionEnum.NORTH);
			break;
		default:
			toContinue = false;
		}

		return toContinue;
	}

}
