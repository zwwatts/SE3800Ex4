package core;

import java.util.ArrayList;

public class History {
	private ArrayList<StoredCommand> history = new ArrayList<StoredCommand>();
	public void add(StoredCommand toAdd){
		history.add(toAdd);
	}
	public void clear(){
		history.clear();
	}
	public StoredCommand get(int commandIndex) throws IndexOutOfBoundsException{
		return history.get(commandIndex);
	}
	public boolean isEmpty(){
		return history.isEmpty();
	}
	public String printHist(){
		String histString ="";
		for(int j=0; j<history.size(); j++){
			histString += (j + ": " + history.get(j)+"\n");
		}
		return histString;
	}
	public int substitute(String rawInput){
		rawInput = rawInput.replace("!", "");
		int histNumber = Integer.parseInt(rawInput);
		return  history.get(histNumber).result;
	}
}
