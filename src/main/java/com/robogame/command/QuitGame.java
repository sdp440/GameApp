/**
 * 
 */
package com.robogame.command;

import com.robogame.exception.CustomException;
import com.robogame.setup.PositionSetup;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class QuitGame implements Position{
	
	@Override
	public boolean executeCommand(String inputCmd,PositionSetup positionSetup) throws CustomException {
		//Can extend the functionality later based on requirements like, re-confirming the user's decision to quit.
		return false;
	}

}
