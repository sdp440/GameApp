/**
 * 
 */
package com.robogame.factory;

import com.robogame.command.Position;
import com.robogame.exception.CustomException;
import com.robogame.setup.PositionSetup;
import com.robogame.setup.PositionSetupImpl;
import com.robogame.util.GameConstants;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class CommandExecutor {
	
	/**
	 * 
	 * @param inputCmdAry
	 * @return toContinue
	 */
	public boolean execService(String[] inputCmdAry) {
		boolean toContinue = true;
		PositionSetup positionSetup = PositionSetupImpl.getInstance();
		CommandFactory cmdFactory = new CommandFactory();
		try {
			Position position = cmdFactory.getCommandExecutor(inputCmdAry[GameConstants.ZERO]);
			String inputCoordinates = (inputCmdAry.length>GameConstants.ONE) ? inputCmdAry[GameConstants.ONE]:GameConstants.EMPTY;
			toContinue = position.executeCommand(inputCoordinates, positionSetup);
		} catch (CustomException exception) {
			//Do Nothing for Invalid commands and continue.
		}
		return toContinue;
	}
	
}
