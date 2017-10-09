/**
 * 
 */
package com.robogame.main;

import java.util.Scanner;

import com.robogame.factory.CommandExecutor;
import com.robogame.util.GameConstants;


/**
 * @author Sundeep Bellumkenda
 *
 */
public class GameLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		boolean toContinue = true;
		System.out.println(GameConstants.INP_CMD);
		try {
			while (toContinue) {
				String[] inputCmdAry = inputScanner.nextLine().split(GameConstants.SPACE);
				CommandExecutor executor = new CommandExecutor();
				toContinue =executor.execService(inputCmdAry);
			}
		} finally {
			inputScanner.close();
		}
	}
}
