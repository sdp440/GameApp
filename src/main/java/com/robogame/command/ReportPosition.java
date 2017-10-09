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
public class ReportPosition implements Position {
	
	@Override
	public boolean executeCommand(String inputCmd,PositionSetup positionSetup) throws CustomException {
		PositionValidator posValidator = new PositionValidator();
		posValidator.validateInputCommand(positionSetup);
		System.out.println(positionSetup.getCordinates().getLattitude() + GameConstants.COMA
				+ positionSetup.getCordinates().getLongitude() + GameConstants.COMA + positionSetup.getDirectionFacing());
		return true;
	}

}
