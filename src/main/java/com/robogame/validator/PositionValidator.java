/**
 * 
 */
package com.robogame.validator;

import com.robogame.exception.CustomException;
import com.robogame.setup.PositionSetup;
import com.robogame.util.GameConstants;
import com.robogame.util.LattLongData;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class PositionValidator {

	/**
	 * 
	 * @param coordinates
	 * @return boolean
	 */
	public boolean isOutOfRange(LattLongData coordinates) {
		if (coordinates.getLattitude() > GameConstants.FOUR || coordinates.getLattitude() < GameConstants.ZERO
				|| coordinates.getLongitude() > GameConstants.FOUR
				|| coordinates.getLongitude() < GameConstants.ZERO) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param positionSetup
	 * @throws CustomException
	 */
	public void validateCoordinates(PositionSetup positionSetup) throws CustomException {
		PositionValidator posValidator = new PositionValidator();
		if (posValidator.isOutOfRange(positionSetup.getCordinates())) {
			if(positionSetup.getCordinates().getLattitude() < GameConstants.ZERO && positionSetup.getCordinates().getLongitude() < GameConstants.ZERO) {
				positionSetup.setCordinates(new LattLongData(GameConstants.ZERO, GameConstants.ZERO));
				throw new CustomException(GameConstants.MIN);
			}
			if(positionSetup.getCordinates().getLattitude() > GameConstants.FOUR && positionSetup.getCordinates().getLongitude() > GameConstants.FOUR) {
				positionSetup.setCordinates(new LattLongData(GameConstants.FOUR, GameConstants.FOUR));
				throw new CustomException(GameConstants.MAX);
			}
			if (positionSetup.getCordinates().getLattitude() < GameConstants.ZERO) {
				positionSetup.setCordinates(new LattLongData(GameConstants.ZERO, positionSetup.getCordinates().getLongitude()));
				throw new CustomException(GameConstants.MIN_LAT);
			}
			if (positionSetup.getCordinates().getLongitude() < GameConstants.ZERO) {
				positionSetup.setCordinates(new LattLongData(positionSetup.getCordinates().getLattitude(), GameConstants.ZERO));
				throw new CustomException(GameConstants.MIN_LONG);
			}
			if (positionSetup.getCordinates().getLattitude() >= GameConstants.FOUR) {
				positionSetup.setCordinates(new LattLongData(GameConstants.FOUR, positionSetup.getCordinates().getLongitude()));
				throw new CustomException(GameConstants.MAX_LAT);
			}
			if (positionSetup.getCordinates().getLongitude() >= GameConstants.FOUR) {
				positionSetup.setCordinates(new LattLongData(positionSetup.getCordinates().getLattitude(), GameConstants.FOUR));
				throw new CustomException(GameConstants.MAX_LONG);
			}
		}
	}
	
	/**
	 * 
	 * @param positionSetup
	 * @throws CustomException
	 */
	public void validateInputCommand(PositionSetup positionSetup) throws CustomException {
		if(positionSetup.getCordinates() == null){
			throw new CustomException(GameConstants.INVLD_INP_NOW);
		}
	}
	
	/**
	 * 
	 * @param inputCmd
	 * @throws CustomException
	 */
	public void validatePlace(String inputCmd) throws CustomException {
		if(inputCmd.length()<1){
			throw new CustomException(GameConstants.INVLD_INP_NOW);
		}
	}
	
	
	

}
