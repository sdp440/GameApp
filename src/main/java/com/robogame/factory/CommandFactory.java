/**
 * 
 */
package com.robogame.factory;

import org.apache.commons.lang3.EnumUtils;

import com.robogame.command.MovePosition;
import com.robogame.command.PlacePosition;
import com.robogame.command.Position;
import com.robogame.command.QuitGame;
import com.robogame.command.ReportPosition;
import com.robogame.command.TurnLeft;
import com.robogame.command.TurnRight;
import com.robogame.exception.CustomException;
import com.robogame.util.GameConstants;
import com.robogame.util.InstructionEnum;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class CommandFactory {

	/**
	 * 
	 * @param cmd
	 * @return Position
	 * @throws CustomException
	 */
	public Position getCommandExecutor(String cmd) throws CustomException {
		if (EnumUtils.isValidEnum(InstructionEnum.class, cmd)) {
			switch (InstructionEnum.valueOf(cmd)) {
			case PLACE:
				return new PlacePosition();
			case REPORT:
				return new ReportPosition();
			case MOVE:
				return new MovePosition();
			case RIGHT:
				return new TurnRight();
			case LEFT:
				return new TurnLeft();
			case QUIT:
				return new QuitGame();
			default:
				throw new CustomException(GameConstants.INVLD_INP);
			}
		} else {
			throw new CustomException(GameConstants.INVLD_INP);
		}
	}

}
