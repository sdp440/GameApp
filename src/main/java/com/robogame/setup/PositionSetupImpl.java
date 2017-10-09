/**
 * 
 */
package com.robogame.setup;

import org.apache.commons.lang3.EnumUtils;

import com.robogame.exception.CustomException;
import com.robogame.util.DirectionEnum;
import com.robogame.util.GameConstants;
import com.robogame.util.LattLongData;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class PositionSetupImpl implements PositionSetup {
	
	private static final PositionSetupImpl instance = new PositionSetupImpl();
	private PositionSetupImpl(){}
	private LattLongData coordinates;
	private DirectionEnum directionFacing;
	
	/**
	 * 
	 * @return instance
	 */
	public static PositionSetupImpl getInstance(){
        return instance;
    }
	
	@Override
	public void setPosition(String inputCmdAry, LattLongData roboPos) throws CustomException {
		String[] inputVals = inputCmdAry.split(GameConstants.COMA);
		setCordinates(new LattLongData(Integer.parseInt(inputVals[GameConstants.ZERO]), Integer.parseInt(inputVals[GameConstants.ONE])));
		if (EnumUtils.isValidEnum(DirectionEnum.class, inputVals[GameConstants.TWO])) {
			setDirectionFacing(DirectionEnum.valueOf(inputVals[GameConstants.TWO]));
		} else {
			throw new CustomException(GameConstants.INVLD_INP);
		}
		this.coordinates = roboPos;
	}
	
	@Override
	public LattLongData getCordinates() {
		return coordinates;
	}

	 
	@Override
	public void setCordinates(LattLongData coordinates) {
		this.coordinates = coordinates;
	}

	 
	@Override
	public DirectionEnum getDirectionFacing() {
		return directionFacing;
	}

	 
	@Override
	public void setDirectionFacing(DirectionEnum directionFacing) {
		this.directionFacing = directionFacing;
	}

	

}
