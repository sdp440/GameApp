/**
 * 
 */
package com.robogame.setup;

import com.robogame.exception.CustomException;
import com.robogame.util.DirectionEnum;
import com.robogame.util.LattLongData;

/**
 * @author Sundeep Bellumkenda
 *
 */
public interface PositionSetup {
	
	/**
	 * 
	 * @param inputCmdAry
	 * @param positionSetup
	 * @throws ExitException
	 * @throws CustomException
	 */
	public void setPosition(String inputCmdAry, LattLongData cordinates) throws CustomException;
	
	
	/**
	 * 
	 * @return LattLongData
	 */
	public LattLongData getCordinates();
	
	/**
	 * 
	 * @param cordinates
	 */
	public void setCordinates(LattLongData cordinates);
	
	/**
	 * 
	 * @return RoboPosEnum
	 */
	public DirectionEnum getDirectionFacing();
	
	/**
	 * 
	 * @param roboFacing
	 */
	public void setDirectionFacing(DirectionEnum dirFacing);

}
