package ch.bbw.zork;/** * Author:  Michael Kolling, Version: 1.1, Date: August 2000 * refactoring: Rinaldo Lanza, September 2020 */import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.stream.Collectors;public class Room {	private String name;	private String description;	private HashMap<String, Room> exits;	public Room( String name, String description) {		this.name = name;		this.description = description;		this.exits = new HashMap<>();	}	public void setExits(Room north, Room east, Room south, Room west, Room lastRoom) {		exits.put("north", north);		exits.put("east", east);		exits.put("south", south);		exits.put("west", west);		exits.put("back", lastRoom);	}	public String shortDescription() {		return description;	}	public String longDescription() {		StringBuilder stringBuilder = new StringBuilder("You are in " + description + ".\n");		stringBuilder.append(exitString());		return stringBuilder.toString();	}	private String exitString() {		return "Exits:" + String.join(" ", exits.keySet());	}	public Room nextRoom(String direction, Room lastRoom) {		exits.put("back", lastRoom);		return exits.get(direction);	}	public String getRoomName(){		return this.name;	}	public Room goBackRoom() {		return exits.get("lastRoom");	}}