package org.irishhombre.api;
 
/**
 * @author IrishHombre
 * 
 */
import org.irishhombre.bo.GameManager;  

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
 
@Path("/guess")
public class GuessNumberService {

	@GET
	@Path("{g}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response guessNumber(@PathParam("g") Integer g, @Context HttpHeaders headers) {		
		GameManager gm = GameManager.getInstance();
		Integer guess = g;
		Integer gameIdInt = null;
		String gameIdStr = null;

		if(headers.getRequestHeader("game-id") != null) {
			gameIdStr = headers.getRequestHeader("game-id").get(0);
		}
		//If no gameId, then start a new game before making a guess
		if(gameIdStr == null) {
			gameIdInt = gm.startGame();
		} else {
			gameIdInt = new Integer(gameIdStr);
		}

 		String res = gm.makeGuess(g, gameIdInt);
 		if(res.equals("bingo")) {
 			gm.endGame(gameIdInt);
 		}

		// return HTTP response 
		return Response.status(200).header("game-id", gameIdInt.toString()).entity(res).build();
	}

	@GET
	@Path("/start")
	@Produces(MediaType.TEXT_PLAIN)
	public Response startGame() {
		String result = "I have chosen a number, begin guessing.";
 		GameManager gm = GameManager.getInstance();
		Integer gameIdInt = gm.startGame();

		// return HTTP response 200 in case of success
		return Response.status(200).header("game-id", gameIdInt.toString()).entity(result).build();
	}
  
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyService() {
		String result = "GuessNumberService Successfully started.";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
 
}