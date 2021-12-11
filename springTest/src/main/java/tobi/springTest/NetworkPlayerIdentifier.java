package tobi.springTest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

public class NetworkPlayerIdentifier {
	
	private final String identifier;
	
	@JsonCreator
	public NetworkPlayerIdentifier(String identifier) {
		System.out.println("IDENTIFIER: " + identifier);
		this.identifier = identifier;
	}
	
	@JsonGetter(JSONnames.PLAYER_ID)
	public String getIdentifier() {
		return this.identifier;
	}
	
	@Override
	public int hashCode() {
		return this.identifier.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NetworkPlayerIdentifier)) {
			return false;
		}
		return (((NetworkPlayerIdentifier)o).hashCode() == this.hashCode());
	}
}