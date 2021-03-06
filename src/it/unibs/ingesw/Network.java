package it.unibs.ingesw;

import java.util.ArrayList;


public class Network implements IDNameGiver{
	
	private ArrayList<Location> locations;
	private ArrayList<Transition> transitions;
	private ArrayList<Link> netLinks;
	private int netId; 
	private String name;
	static int network_id = 0;			//Variabile statica che fornisce un id diverso ogni qualvolta si crea una rete
	private final int OFFSET = 10000;	//Costante che viene sommata all'id di un node nel caso quest'ultimo sia una location
	
	public Network (String name) {
		locations = new ArrayList<Location>();
		transitions = new ArrayList<Transition>();
		netLinks = new ArrayList<Link>();
		this.name = name;
		this.netId = ++network_id;
	}

	public void addLocation (String name) {
		locations.add(new Location(netId, locations.size()+OFFSET, name));
	}


	public void addTransition (String name) {
		transitions.add(new Transition(netId, transitions.size(), name));
	}
	
	public void addLink (Link l) {
		netLinks.add(l);
	}
	
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public Location getLocation(int i) {
		return this.locations.get(i);
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}
	
	public Transition getTransition(int i) {
		return this.transitions.get(i);
	}

	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	public ArrayList<Link> getNetLinks() {
		return netLinks;
	}

	public void setNetLinks(ArrayList<Link> netLinks) {
		this.netLinks = netLinks;
	}

	public int getId() {
		return netId;
	}

	public void setNetId(int netId) {
		this.netId = netId;
	}
	
	/**
	 * Produce in uscita la lista delle transizioni con associato un numero
	 * @return StringBuffer s
	 */
	public StringBuffer getTransitionsList() {
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i<transitions.size(); i++) {
			s.append(i + ")" + transitions.get(i).getName() + "\n");
		}
		return s;
	}
	
	/**
	 * Produce in uscita la lista dei posti con associato un numero 
	 * @return StringBuffer s
	 */
	public StringBuffer getLocationsList() {
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i<locations.size(); i++) {
			s.append(i + ")" + locations.get(i).getName() + "\n");
		}
		return s;
	}
	
	/**
	 * Produce in uscita la lista dei link
	 * @return Stringbuffer s
	 */
	public StringBuffer getLinksList() {
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i < netLinks.size(); i++) {
			s.append(i + ")" + nodeNameFromID(netLinks.get(i).getOrigin()) + "---->" + nodeNameFromID(netLinks.get(i).getDestination())+ "\n");
		}
		return s;
	}
	
	public Transition getLastTransition() {
		return transitions.get(transitions.size()-1);
	}
	
	public Location getLastLocation() {
		return locations.get(locations.size()-1);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * produce in uscita il nome della location o transition associata all'ID fornito in ingresso al metodo 
	 * @param int id
	 * @return String t.getName()
	 */
	public String nodeNameFromID(int id) {
		for(Location l : locations) {
			if(l.getId() == id)
				return l.getName();
		}
		for(Transition t : transitions) {
			if(t.getId() == id)
				return t.getName();
		}
		return null;
	}

}
