package org.irishhombre.bo;
 
/**
 * @author IrishHombre
 * 
 */
  
import java.util.Map;
import java.util.HashMap;

public class GameManager {
	private static GameManager instance = null;

	//The games map
	private Map<Integer, Integer> games = null;

	//Celing for guesses
	private int ceiling = 2000000;

	protected GameManager() {
		if(this.games == null) {
			this.games = new HashMap();
		}
	}

	public static GameManager getInstance() {
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
	}

	public Map<Integer, Integer> getGames() {
		return games;
	}
	public void setGames(Map<Integer, Integer> games) {
		this.games = games;
	}

	//Create a new game and return the gameId
	public Integer startGame() {
		Map<Integer, Integer> games = getGames();

		//Generate game session ID
		Integer gameId = new Integer((int)(Math.random()*5000));

		//Generate number for guess
		Integer gameVal = new Integer((int)(Math.random()*ceiling));

		games.put(gameId, gameVal);

		return gameId;
	}

	//End the given game by removing it from the games list
	public void endGame(Integer gameId) {
		Map<Integer, Integer> games = getGames();
		if(games != null) {
			games.remove(gameId);
		}
	}

	public Integer getGameValue(Integer gameId) {
		Integer keyObj = null;
		for (Integer i : games.keySet()) {
			if(((Integer)i).intValue() == gameId.intValue()) {
				keyObj = i;
				break;
			}
		}
		if(keyObj != null) {
			Integer gameVal = (Integer)games.get(keyObj);
			return gameVal;
		}
		return null;
	}

	public String makeGuess(Integer gameId, Integer guess) {
		//Cover that no game exists
		String answer = "Invalid game!";

		Map<Integer, Integer> games = getGames();

		if(games != null) {
			Integer gameValue = getGameValue(gameId);
			if(gameValue != null) {
				if(gameValue.intValue() == guess.intValue()) {
					answer = "bingo";
				} else if(gameValue.intValue() > guess.intValue()) {
					answer = "higher"; 
				} else {
					answer = "lower";
				}
			}
		}
		return answer;
	}

	public Integer getCeiling() {
		return new Integer(this.ceiling);
	}
}