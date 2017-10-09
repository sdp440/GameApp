/**
 * 
 */
package com.robogame.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.robogame.factory.CommandExecutor;
import com.robogame.setup.PositionSetup;
import com.robogame.setup.PositionSetupImpl;
import com.robogame.util.DirectionEnum;

/**
 * @author Sundeep Bellumkenda
 *
 */
public class CommandFactoryTest {
	
	private static PositionSetup roboSetup;
	private static CommandExecutor cmdFactory;
	
	
	@BeforeClass
	public static void initCheck(){
		cmdFactory = new CommandExecutor();
		roboSetup = PositionSetupImpl.getInstance();
	}
	
	@Test
	public void testPlaceRobo(){
		boolean result = false;
		String[] inputCmd = {"PLACE","0,0,NORTH"};
		result = cmdFactory.execService(inputCmd);
		assertEquals(true,result);
	}
	
	@Test
	public void testMoveRobo(){
		boolean result = false;
		String[] inputCmd = {"MOVE"};
		roboSetup.setDirectionFacing(DirectionEnum.EAST);
		result = cmdFactory.execService(inputCmd);
		assertEquals(true,result);
	}

}
