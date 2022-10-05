package prob1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MartianManager {
	protected Map<Integer,Martian>  martians = new HashMap<>();
	protected Map<Integer,Teleporter> teleporters = new HashMap<>();
	
	public MartianManager(){}
	
	public boolean addMartian(Martian m) {
		int id = m.getId();
		if(martians.containsValue(m)) {
			return false;
		}
		else {
			martians.put(id, m);
			if(m instanceof Teleporter) {
				Teleporter t = (Teleporter)m;
				teleporters.put(id,t);
			}
			return true;
		}
	}
	
	public ArrayList<Martian> battle(ArrayList<Martian> invaders){
		ArrayList<Martian> killed = new ArrayList<>();
		for(Martian in: invaders) {
			int inPow = getPower(in);
			for(Martian def: martians.values()) {
				int defPow = getPower(def);
				if(inPow>defPow) {
					killed.add(removeMartian(def.getId()));
					break;
				}
			}
		}
		return killed;
	}
	
	public boolean contains(int id) {
		if(martians.containsKey(id)) {
			return true;
		}
		return false;	
	}
	
	public Martian getMartianClosestTo(int id) {   
		int lowNum = Integer.MAX_VALUE;
		Martian Closest = martians.get(0);
		for(Martian m: martians.values()) {
			int holder = Math.abs(m.getId() - id);
			if(holder < lowNum) {
				lowNum = holder;
				Closest = m;
			}
		}
		return Closest;
	}
	
	public Martian getMartianClosestTo(Martian martian) {
		return getMartianClosestTo(martian.getId());
	}
	
	public Martian getMartian(int id) {
			if(martians.containsKey(id)) {
				return martians.get(id);
			}
			return null;
	}
	
	public  int getNumMartians() {
		return martians.size();
	}
	
	public int getNumTeleporters() {
		return teleporters.size();
	}
	
	//Helper method used by the battle method
	public int getPower(Martian e) {
		int power;
		if(e instanceof GreenMartian) {
			GreenMartian m = (GreenMartian)e;
			power = m.getVolume(); 
		}
		else {
			RedMartian m = (RedMartian)e;
			power = m.getVolume() + m.getTenacity();
		}
		return power;
	}
	
	public ArrayList<Martian> getSortedMartians(String sortType){
		ArrayList<Martian> sorted = new ArrayList<>(martians.values());
		if(sortType.equals("ID")) {
			Collections.sort(sorted, new MartianIdComparator());
		}
		if(sortType.equals("VOLUME")) {
			Collections.sort(sorted, new MartianVolumeComparator());
		}
		return sorted;
	}
	
	public Teleporter getTeleporter(int id) {
		if(teleporters.containsKey(id)){
			return teleporters.get(id);
		}
		return null;
	}
	
	public String groupSpeak() {
		String msg = "";
		for (Martian m: martians.values()) {
			msg += m.speak() + "\n";
		}
		return msg;
	}
	
	public String groupTeleport(String dest) {
		String msg = "";
		for (Teleporter m: teleporters.values()) {
			msg += m.teleport(dest) + "\n";
		}
		return msg;
	}
	
	public void obliterateTeleporters() {   
		martians.values().removeIf(m -> (m instanceof Teleporter));
		teleporters.clear();
	}
	
	public Martian removeMartian(int id) {
		if(martians.containsValue(getMartian(id))){
			Martian m = getMartian(id);
			martians.remove(id);
			if(m instanceof Teleporter) {
				teleporters.remove(id);
			}
			return m;
		}
		return null;
	}
	
	public void increaseTeleportersVolume(int idTheshold) {
		for(Martian m: martians.values()) {
			if(m.getVolume() < idTheshold) {
				if(m instanceof GreenMartian) {
					GreenMartian replace = new GreenMartian(m.getId(), (m.getVolume() + 1));
					martians.put(m.getId(), replace);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String msg1 = "Martians:";
		String msg2 = "Teleporters:";
		for(Martian m: martians.values()) {
			msg1 += "\n" + m.toString();
			if(m instanceof Teleporter) {
				Teleporter f = (Teleporter)m;
				msg2 += "\n" + f.toString();
			}
		}
		String together = msg1 + "\n\n" + msg2;
		return together;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
