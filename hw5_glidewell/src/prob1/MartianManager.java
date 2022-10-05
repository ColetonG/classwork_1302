package prob1;

import java.util.ArrayList;
import java.util.Collections;

public class MartianManager {
	protected ArrayList<Martian>  martians = new ArrayList<>();
	protected ArrayList<Teleporter> teleporters = new ArrayList<>();
	
	public MartianManager(){}
	
	public boolean addMartian(Martian m) {
		if(martians.contains(m)) {
			return false;
		}
		else {
			martians.add(m);
			if(m instanceof Teleporter) {
				Teleporter t = (Teleporter)m;
				teleporters.add(t);
			}
			return true;
		}
	}
	
	public ArrayList<Martian> battle(ArrayList<Martian> invaders){
		ArrayList<Martian> killed = new ArrayList<>();
		for(Martian in: invaders) {
			int inPow = getPower(in);
			for(Martian def: martians) {
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
		for(Martian m:martians) {
			if(m.getId()==id) {
				return true;
			}
		}
		return false;	
	}
	
	public Martian getMartianAt(int i) {
		if(i<0 || i>martians.size()) {
			return null;
		}
		else {
			return martians.get(i);
		}
	}
	
	public Martian getMartianClosestTo(int id) {   
		int lowNum = Integer.MAX_VALUE;
		Martian Closest = martians.get(0);
		for(Martian m: martians) {
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
	
	public Martian getMartianWithId(int id) {
		for(Martian m: martians) {
			if(m.getId()==id) {
				return m;
			}
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
	
	public ArrayList<Martian> getSortedMartian(){
		ArrayList<Martian> sorted = martians;
		Collections.sort(sorted);
		return sorted;
	}
	
	public Teleporter getTeleporterAt(int i) {
		if(i<0 || i>teleporters.size()) {
			return null;
			}
		else {
			return teleporters.get(i);
			}
	}
	
	public String groupSpeak() {
		String msg = "";
		for (Martian m: martians) {
			msg += m.speak() + "\n";
		}
		return msg;
	}
	
	public String groupTeleport(String dest) {
		String msg = "";
		for (Teleporter m: teleporters) {
			msg += m.teleport(dest) + "\n";
		}
		return msg;
	}
	
	public void obliterateTeleporters() {   
		martians.removeIf(m -> (m instanceof Teleporter));
		teleporters.clear();
	}
	
	public Martian removeMartian(int id) {
		if(martians.contains(getMartianWithId(id))){
			Martian m = getMartianWithId(id);
			martians.remove(m);
			if(m instanceof Teleporter) {
				Teleporter f = (Teleporter)m;
				teleporters.remove(f);
			}
			return m;
		}
		return null;
	}
	
	@Override
	public String toString() {
		String msg1 = "Martians:";
		String msg2 = "Teleporters:";
		for(Martian m: martians) {
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
