/**
 * 
 */
package com.robogame.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.robogame.command.MovePosition;
import com.robogame.command.PlacePosition;
import com.robogame.command.Position;
import com.robogame.command.ReportPosition;
import com.robogame.command.TurnLeft;
import com.robogame.command.TurnRight;
import com.robogame.exception.CustomException;
import com.robogame.setup.PositionSetupImpl;
import com.robogame.util.DirectionEnum;
import com.robogame.util.GameConstants;
import com.robogame.util.LattLongData;

import junit.framework.Assert;


/**
 * @author Sundeep Bellumkenda
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PositionTest {
	@Before
	public void initServiceVars() {
		positionSetup = PositionSetupImpl.getInstance();
		coordinates = Mockito.mock(LattLongData.class);
		report = Mockito.mock(ReportPosition.class);
		left = new TurnLeft();
		right = new TurnRight();
		move = new MovePosition();
		place = new PlacePosition();
	}
	
	@InjectMocks
	PositionSetupImpl positionSetup;
	LattLongData coordinates;
	//DirectionEnum roboFacing;
	Position report;
	Position left;
	Position right;
	Position move;
	Position place;
	
	
	
	@Test
	public void reportTest(){
		coordinates = new LattLongData();
		coordinates.setLattitude(GameConstants.ONE);
		coordinates.setLongitude(GameConstants.ZERO);
		positionSetup.setCordinates(coordinates);
		positionSetup.setDirectionFacing(DirectionEnum.NORTH);
		boolean thrown = false;
		try {
			Mockito.doThrow(new CustomException("Done")).when(report).executeCommand(null,positionSetup);
			report.executeCommand(null,positionSetup);
		} catch (CustomException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void leftTest(){
		coordinates = new LattLongData();
		coordinates.setLattitude(GameConstants.ONE);
		coordinates.setLongitude(GameConstants.ZERO);
		positionSetup.setCordinates(coordinates);
		positionSetup.setDirectionFacing(DirectionEnum.NORTH);
			try {
				left.executeCommand(null,positionSetup);
			} catch (CustomException e) {
				e.printStackTrace();
			}
		Assert.assertEquals(DirectionEnum.WEST, positionSetup.getDirectionFacing());
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void rightTest(){
		coordinates = new LattLongData();
		coordinates.setLattitude(GameConstants.ONE);
		coordinates.setLongitude(GameConstants.ZERO);
		positionSetup.setCordinates(coordinates);
		positionSetup.setDirectionFacing(DirectionEnum.NORTH);
		try {
			right.executeCommand(null,positionSetup);
		} catch (CustomException e) {
		}
		Assert.assertEquals(DirectionEnum.EAST, positionSetup.getDirectionFacing());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void moveTest(){
		coordinates = new LattLongData();
		coordinates.setLattitude(GameConstants.ONE);
		coordinates.setLongitude(GameConstants.ZERO);
		positionSetup.setCordinates(coordinates);
		positionSetup.setDirectionFacing(DirectionEnum.NORTH);
		try {
			move.executeCommand(null,positionSetup);
		} catch (CustomException e) {
		}
		Assert.assertEquals(GameConstants.ONE, positionSetup.getCordinates().getLongitude());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void placeTest(){
		coordinates = new LattLongData();
		coordinates.setLattitude(GameConstants.ZERO);
		coordinates.setLongitude(GameConstants.ZERO);
		positionSetup.setCordinates(coordinates);
		positionSetup.setDirectionFacing(DirectionEnum.NORTH);
		try {
			place.executeCommand("0,0,NORTH",positionSetup);
		} catch (CustomException e) {
		}
		Assert.assertEquals(GameConstants.ZERO, positionSetup.getCordinates().getLattitude());
	}

}
