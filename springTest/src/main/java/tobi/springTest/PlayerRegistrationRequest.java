package tobi.springTest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerRegistrationRequest {
	
	private final String playerName;
	
	@JsonCreator
	public PlayerRegistrationRequest(@JsonProperty(value = JSONnames.PLAYER_NAME, required = true) String name) {
		this.playerName = name;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}

	@JsonIgnore
	public String getPrintString() {
		return this.getClass().getName() + ": '" + JSONnames.PLAYER_NAME + "'='" + this.playerName + "'";
	}
	
}
