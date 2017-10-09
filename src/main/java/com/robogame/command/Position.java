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
public interface Position {
	
	/**
	 * 
	 * @param inputCmd
	 * @param positionSetup
	 * @throws CustomException
	 */
	public boolean executeCommand(String inputCmd,PositionSetup positionSetup) throws CustomException;

}
