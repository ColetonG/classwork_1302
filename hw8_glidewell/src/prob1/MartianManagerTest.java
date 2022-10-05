package prob1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MartianManagerTest {

	public static void main(String[] args) {
		addMartian_Red_Success();
		addMartian_Green_Success();
		addMartian_RedGreen_Failure();
		addMartian_GreenRed_Failure();
		testContains_Success();
		testContains_Failure();
		testGetMartianClosestTo_Index_LowerMatch();
		testGetMartianClosestTo_Index_HigherMatch();
		testGetMartianClosestTo_Martian_LowerMatch();
		testGetMartianWithId_Success();
		testGetMartianWithId_Failure();
		getSortedMartians_Id();		
		getSortedMartians_Volume();  
		testGetTeleporterWithId_Success();	
		testGetTeleporterWithId_Failure();
		testGroupSpeak();
		testGroupTeleport();
		testObliterateTeleporters_One();
		testObliterateTeleporters_Many();
		testRemoveMartianWithId_Success_Red();
		testRemoveMartianWithId_Success_Green();
		testRemoveMartianWithId_Failure();
		testToString();
		testBattle_oneInvader_oneKill();
		testBattle_oneInvader_noKill();
		testBattle_small();
		testBattle_Larger();
		testBattle_2_2_2();
		testBattle_2_3_2();
		testIncreaseTeleportersVolume();
	}
	
	public static void addMartian_Red_Success() {
		System.out.println("-->addMartian_Red_Success");
		MartianManager vod = new MartianManager();
		RedMartian sar = new RedMartian(5, 4);
		vod.addMartian(sar);
		String list = vod.toString();
		String msg = String.format("Manager with one RedMartian:\n%s", list);
		System.out.println(msg);
	}
	
	public static void addMartian_Green_Success() {
		System.out.println("\n-->addMartian_Green_Success");
		MartianManager vod = new MartianManager();
		GreenMartian sar = new GreenMartian(5, 4);
		vod.addMartian(sar);
		String list = vod.toString();
		String msg = String.format("Manager with one GreenMartian:\n%s", list);
		System.out.println(msg);
	}
	
	public static void addMartian_RedGreen_Failure() {
		System.out.println("\n-->addMartian_RedGreen_Failure");
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(5,6);
		GreenMartian sar = new GreenMartian(5, 4);
		vod.addMartian(it); vod.addMartian(sar);
		String list = vod.toString();
		String msg = String.format("Manager with one RedMartian:\n%s", list);
		System.out.println(msg);
	}
	
	public static void addMartian_GreenRed_Failure() {
		System.out.println("\n-->addMartian_GreenRed_Failure");
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(5,6);
		GreenMartian sar = new GreenMartian(5, 4);
		vod.addMartian(sar); vod.addMartian(it);
		String list = vod.toString();
		String msg = String.format("Manager with one RedMartian:\n%s", list);
		System.out.println(msg);
	}
	
	public static void testContains_Success() {
		System.out.println("\n-->testContains_Success");
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(5,6);
		GreenMartian sar = new GreenMartian(6, 4);
		vod.addMartian(sar); vod.addMartian(it);
		int id = 5;
		boolean ex = true;
		boolean ac = vod.contains(id);
		String msg = String.format("Expected result: %b", ex);
		msg += String.format("\nActaul result: %b", ac);
		System.out.println(msg);
	}
	
	public static void testContains_Failure() {
		System.out.println("\n-->testContains_Failure");
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(5,6);
		GreenMartian sar = new GreenMartian(6, 4);
		vod.addMartian(sar); vod.addMartian(it);
		int id = 2;
		boolean ex = false;
		boolean ac = vod.contains(id);
		String msg = String.format("Expected result: %b", ex);
		msg += String.format("\nActaul result: %b", ac);
		System.out.println(msg);
	}
	
	public static void testGetMartianClosestTo_Index_LowerMatch() {
		System.out.println("\n-->testGetMartianClosestTo_Index_LowerMatch");
		MartianManager vod = managerWith5();
		int id = 4;
		String ex = "Green Martian with id 3";
		String ac = vod.getMartianClosestTo(id).toString();
		String msg = String.format("Expected result: %s", ex);
		msg += String.format("\nActual result: %s", ac);
		System.out.println(msg);
	}
	
	public static void testGetMartianClosestTo_Index_HigherMatch() {
		System.out.println("\n-->testGetMartianClosestTo_Index_HigherMatch");
		MartianManager vod = managerWith5();
		int id = 6;
		String ex = "Red Martian with id 8";
		String ac = vod.getMartianClosestTo(id).toString();
		String msg = String.format("Expected result: %s", ex);
		msg += String.format("\nActual result: %s", ac);
		System.out.println(msg);
	}
	
	public static void testGetMartianClosestTo_Martian_LowerMatch() {
		System.out.println("\n-->testGetMartianClosestTo_Martian_LowerMatch");
		MartianManager vod = managerWith5();
		GreenMartian seb = new GreenMartian(6,5);
		String ex = "Red Martian with id 8";
		String ac = vod.getMartianClosestTo(seb).toString();
		String msg = String.format("Expected result: %s", ex);
		msg += String.format("\nActual result: %s", ac);
		System.out.println(msg);
	}
	
	public static void testGetMartianWithId_Success() {
		System.out.println("\n-->testGetMartianWithId_Success");
		MartianManager vod = managerWith5();
		int id = 3;
		String ex = "Green Martian with id:3";
		Martian ac = vod.getMartian(id);
		String msg = String.format("Expected result: %s", ex);
		msg += String.format("\nActual result: %s", ac);
		System.out.println(msg);
	}
	
	public static void testGetMartianWithId_Failure() {
		System.out.println("\n-->testGetMartianWithId_Failure");
		MartianManager vod = managerWith5();
		int id = 88;
		String ex = "null";
		Martian ac = vod.getMartian(id);
		String msg = String.format("Expected result: %s", ex);
		msg += String.format("\nActual result: %s", ac);
		System.out.println(msg);
	}
	
	public static void getSortedMartians_Id() {               //---------------------------------
		System.out.println("\n-->getSortedMartians_Id");
		MartianManager vod = managerWithOutO();
		String before = vod.toString();
		String after = formatedArray(vod.getSortedMartians("ID"));
		String msg = String.format("toString before sorted:\n %s", before);
		msg += String.format("\n\nAfter sorted:\n %s", after);
		System.out.println(msg); 
	}
	
	public static void getSortedMartians_Volume() {
		System.out.println("\n-->getSortedMartians_Volume");
		MartianManager vod = managerWithOutO();
		String before = vod.toString();
		String after = formatedArray(vod.getSortedMartians("VOLUME"));
		String msg = String.format("toString before sorted:\n %s", before);
		msg += String.format("\n\nAfter sorted:\n %s", after);
		System.out.println(msg); 
	}                                                       //-----------------------------------------
	
	public static void testGetTeleporterWithId_Success() {
		System.out.println("\n-->testGetTeleporterWithId_Success");
		MartianManager vod = managerWith6();
		int index = 77;
		String ex = "Green Martian with id 77";
		Teleporter ac = vod.getTeleporter(index);
		String msg = String.format("Expected result: %s", ex);
		msg += String.format("\nActual result: %s", ac);
		System.out.println(msg);
	}
	
	public static void testGetTeleporterWithId_Failure() {
		System.out.println("\n-->testGetTeleporterWithId_Failure");
		MartianManager vod = managerWith6();
		int index = -2;
		String ex = "null";
		Teleporter ac = vod.getTeleporter(index);
		String msg = String.format("Expected result: %s", ex);
		msg += String.format("\nActual result: %s", ac);
		System.out.println(msg);
	}
	
	public static void testGroupSpeak() {
		System.out.println("\n-->testGroupSpeak");
		MartianManager vod = new MartianManager();
		GreenMartian sam = new GreenMartian(4,4);
		RedMartian sar = new RedMartian(5, 4);
		RedMartian bob = new RedMartian(42,4);		
		vod.addMartian(sam);
		vod.addMartian(sar);
		vod.addMartian(bob);
		String msg =vod.groupSpeak();
		System.out.println(msg);
	}
	
	public static void testGroupTeleport() {
		System.out.println("\n-->testGroupTeleport");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(42,4);
		GreenMartian sam = new GreenMartian(4,4);
		GreenMartian sar = new GreenMartian(5, 4);
		GreenMartian tom = new GreenMartian(6,4);		
		vod.addMartian(sam);
		vod.addMartian(sar);
		vod.addMartian(bob);
		vod.addMartian(tom);
		String msg =vod.groupTeleport("Mars");
		System.out.println(msg);
	}
	
	public static void testObliterateTeleporters_One() {
		System.out.println("\n-->testObliterateTeleporters_One");
		MartianManager vod = managerWithOneGreen();
		String before = vod.toString();
		vod.obliterateTeleporters();
		String after = vod.toString();
		String msg = String.format("Before obliterating:\n%s", before);
		msg += String.format("\nAfter obliterating:\n%s", after);
		System.out.println(msg);
	}
	
	public static void testObliterateTeleporters_Many() {
		System.out.println("\n-->testObliterateTeleporters_Many");
		MartianManager vod = managerWithHalf();
		String before = vod.toString();
		vod.obliterateTeleporters();
		String after = vod.toString();
		String msg = String.format("Before obliterating:\n%s", before);
		msg += String.format("\nAfter obliterating:\n%s", after);
		System.out.println(msg);
	}
	
	public static void testRemoveMartianWithId_Success_Red() {
		System.out.println("\n-->testRemoveMartianWithId_Success_Red");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(42,4);
		RedMartian sam = new RedMartian(4,4);
		GreenMartian sar = new GreenMartian(5, 4);
		GreenMartian tom = new GreenMartian(6,4);
		vod.addMartian(bob);
		vod.addMartian(sam);
		vod.addMartian(sar);
		vod.addMartian(tom);
		int tag = 4;
		String before = vod.toString();
		String msg1 = String.format("List before remove:\n%s", before);
		vod.removeMartian(tag);
		String after = vod.toString();
		String msg2 = String.format("List after remove (id=%d):\n%s", tag, after);
		String together = msg1 + "\n\n" + msg2;
		System.out.println(together);
	}
	
	public static void testRemoveMartianWithId_Success_Green() {
		System.out.println("\n-->testRemoveMartianWithId_Success_Green");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(42,4);
		RedMartian sam = new RedMartian(4,4);
		GreenMartian sar = new GreenMartian(5, 4);
		GreenMartian tom = new GreenMartian(6,4);
		vod.addMartian(bob);
		vod.addMartian(sam);
		vod.addMartian(sar);
		vod.addMartian(tom);
		int tag = 6;
		String before = vod.toString();
		String msg1 = String.format("List before remove:\n%s", before);
		vod.removeMartian(tag);
		String after = vod.toString();
		String msg2 = String.format("List after remove (id=%d):\n%s", tag, after);
		String together = msg1 + "\n\n" + msg2;
		System.out.println(together);
	}
	
	public static void testRemoveMartianWithId_Failure() {
		System.out.println("\n-->testRemoveMartianWithId_Failure");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(42,4);
		RedMartian sam = new RedMartian(4,4);
		GreenMartian sar = new GreenMartian(5, 4);
		GreenMartian tom = new GreenMartian(6,4);
		vod.addMartian(bob);
		vod.addMartian(sam);
		vod.addMartian(sar);
		vod.addMartian(tom);
		int tag = 100;
		String before = vod.toString();
		String msg1 = String.format("List before remove:\n%s", before);
		vod.removeMartian(tag);
		String after = vod.toString();
		String msg2 = String.format("List after remove (id=%d):\n%s", tag, after);
		String together = msg1 + "\n\n" + msg2;
		System.out.println(together);
	}
	
	public static void testToString() {
		System.out.println("\n-->testToString");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(42,4);
		RedMartian sam = new RedMartian(4,4);
		GreenMartian sar = new GreenMartian(5, 4);
		GreenMartian tom = new GreenMartian(6,4);
		vod.addMartian(bob);
		vod.addMartian(sam);
		vod.addMartian(sar);
		vod.addMartian(tom);
		System.out.println(vod);
	}
	
	public static void testBattle_oneInvader_oneKill() {
		System.out.println("\n-->testBattle_oneInvader_oneKill");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(1,3); //power = 4
		RedMartian sam = new RedMartian(2,5); //power = 6
		GreenMartian sar = new GreenMartian(3, 5);  //power = 5
		vod.addMartian(bob); vod.addMartian(sam); vod.addMartian(sar);
		ArrayList<Martian> invaders = new ArrayList<>();
		GreenMartian i1 = new GreenMartian(2,5); //power = 5
		invaders.add(i1);
		String before = vod.toString();
		ArrayList<Martian> killed = vod.battle(invaders);
		String after = vod.toString();
		String msg = String.format("Before battle:\n%s", before);
		msg += String.format("\nAfter battle (invader power 5):\n%s", after);
		msg += String.format("\nMartians killed: %s", killed);
		System.out.println(msg);
	}
	
	public static void testBattle_oneInvader_noKill() {
		System.out.println("\n-->testBattle_oneInvader_noKill");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(1,3); //power = 4
		RedMartian sam = new RedMartian(2,5); //power = 6
		GreenMartian sar = new GreenMartian(3, 5);  //power = 5
		vod.addMartian(bob); vod.addMartian(sam); vod.addMartian(sar);
		ArrayList<Martian> invaders = new ArrayList<>();
		GreenMartian i1 = new GreenMartian(2,1); //power 1
		invaders.add(i1);
		String before = vod.toString();
		ArrayList<Martian> killed = vod.battle(invaders);
		String after = vod.toString();
		String msg = String.format("Before battle:\n%s", before);
		msg += String.format("\nAfter battle (invader power 5):\n%s", after);
		msg += String.format("\nMartians killed: %s", killed);
		System.out.println(msg);
	}
	
	public static void testBattle_small() {
		System.out.println("\n-->testBattle_small");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(1,3); //power = 4
		RedMartian sam = new RedMartian(2,5); //power = 6
		GreenMartian sar = new GreenMartian(3, 5);  //power = 5
		GreenMartian ras = new GreenMartian(4, 5);  //power = 5
		vod.addMartian(bob); vod.addMartian(sam); vod.addMartian(sar); vod.addMartian(ras);
		ArrayList<Martian> invaders = new ArrayList<>();
		RedMartian boss = new RedMartian(1,9); // power = 10
		GreenMartian i1 = new GreenMartian(2,1); //power 1
		invaders.add(boss);
		invaders.add(i1);
		String before = vod.toString();
		ArrayList<Martian> killed = vod.battle(invaders);
		String after = vod.toString();
		String msg = String.format("Before battle:\n%s", before);
		msg += String.format("\nAfter battle (invader power 10,1):\n%s", after);
		msg += String.format("\nMartians killed: %s", killed);
		System.out.println(msg);
	}
	
	public static void testBattle_Larger() {
		System.out.println("\n-->testBattle_Larger");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(1,3); //power = 4
		RedMartian sam = new RedMartian(2,5); //power = 6
		GreenMartian sar = new GreenMartian(3, 5);  //power = 5
		GreenMartian ras = new GreenMartian(4, 5);  //power = 5
		RedMartian bass = new RedMartian(5, 2, 2); //power = 4
		vod.addMartian(bob); vod.addMartian(sam); vod.addMartian(sar); vod.addMartian(ras);
		vod.addMartian(bass);
		ArrayList<Martian> invaders = new ArrayList<>();
		RedMartian boss = new RedMartian(1,9); // power = 10
		GreenMartian i1 = new GreenMartian(2,1); //power = 1
		RedMartian i2 = new RedMartian(3,4,4); //power = 8
		invaders.add(boss); invaders.add(i1); invaders.add(i2);
		String before = vod.toString();
		ArrayList<Martian> killed = vod.battle(invaders);
		String after = vod.toString();
		String msg = String.format("Before battle:\n%s", before);
		msg += String.format("\nAfter battle (invader power 10,1,8):\n%s", after);
		msg += String.format("\nMartians killed: %s", killed);
		System.out.println(msg);
	}
	
	public static void testBattle_2_2_2() {
		System.out.println("\n-->testBattle_2_2_2");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(1,3); //power = 4
		GreenMartian sam = new GreenMartian(2,5); //power = 5
		vod.addMartian(bob); vod.addMartian(sam);
		ArrayList<Martian> invaders = new ArrayList<>();
		RedMartian boss = new RedMartian(1,9); // power = 10
		RedMartian i1 = new RedMartian(2,4,4); //power = 8
		invaders.add(boss); invaders.add(i1);
		String before = vod.toString();
		ArrayList<Martian> killed = vod.battle(invaders);
		String after = vod.toString();
		String msg = String.format("Before battle:\n%s", before);
		msg += String.format("\nAfter battle (invader power 10,8):\n%s", after);
		msg += String.format("\nMartians killed: %s", killed);
		System.out.println(msg);
	}
	
	public static void testBattle_2_3_2() {
		System.out.println("\n-->testBattle_2_3_2");
		MartianManager vod = new MartianManager();
		RedMartian bob = new RedMartian(1,3); //power = 4
		GreenMartian sam = new GreenMartian(2,5); //power = 5
		vod.addMartian(bob); vod.addMartian(sam);
		ArrayList<Martian> invaders = new ArrayList<>();
		RedMartian boss = new RedMartian(1,9); // power = 10
		RedMartian i1 = new RedMartian(2,4,4); //power = 8
		GreenMartian i2 = new GreenMartian(3,6); //power = 6
		invaders.add(boss); invaders.add(i1);invaders.add(i2);
		String before = vod.toString();
		ArrayList<Martian> killed = vod.battle(invaders);
		String after = vod.toString();
		String msg = String.format("Before battle:\n%s", before);
		msg += String.format("\nAfter battle (invader power 10,8,6):\n%s", after);
		msg += String.format("\nMartians killed: %s", killed);
		System.out.println(msg);
	}
	
	public static void testIncreaseTeleportersVolume() {
		System.out.println("\n-->testIncreaseTeleportersVolume");
		MartianManager vod = managerWith5();
		String before = vod.toString();
		vod.increaseTeleportersVolume(5);  // Increase green martians under 5
		String after = vod.toString();
		String msg = String.format("Before increasing volume:\n%s", before);
		msg += String.format("\nAfter increasing volume:\n%s", after);
		System.out.println(msg);
	}
	
	
	
	
	//---------------------
    // Helper methods
	//---------------------
	
	public static MartianManager managerWith5() {
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(1,6);
		GreenMartian sar = new GreenMartian(3, 4);
		RedMartian bob = new RedMartian(8,4);
		GreenMartian tiny = new GreenMartian(13, 4);
		GreenMartian seb = new GreenMartian(14, 7);
		vod.addMartian(it); vod.addMartian(sar); vod.addMartian(bob);vod.addMartian(tiny);
		vod.addMartian(seb);
		return vod;
	}
	
	public static MartianManager managerWith6() {
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(1,6); //power = 7
		GreenMartian sar = new GreenMartian(3, 4); // power = 4
		RedMartian bob = new RedMartian(8,5); // power = 5
		GreenMartian tiny = new GreenMartian(13, 7); //power = 8
		GreenMartian spine = new GreenMartian(77, 7); //power = 8
		GreenMartian ray = new GreenMartian(88, 7); //power = 8
		vod.addMartian(it); vod.addMartian(sar); vod.addMartian(bob);vod.addMartian(tiny);
		vod.addMartian(spine); vod.addMartian(ray);
		return vod;
	}
	
	public static MartianManager managerWithHalf() {
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(1,6);
		RedMartian sar = new RedMartian(3, 4);
		RedMartian bob = new RedMartian(8,4);
		GreenMartian tiny = new GreenMartian(13, 7);
		GreenMartian spine = new GreenMartian(77, 7);
		GreenMartian ray = new GreenMartian(88, 7);
		vod.addMartian(it); vod.addMartian(sar); vod.addMartian(bob);vod.addMartian(tiny);
		vod.addMartian(spine); vod.addMartian(ray);
		return vod;
	}
	
	public static MartianManager managerWithOneGreen() {
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(1,6);
		RedMartian sar = new RedMartian(3, 4);
		RedMartian bob = new RedMartian(8,4);
		GreenMartian tiny = new GreenMartian(13, 7);
		vod.addMartian(it); vod.addMartian(sar); vod.addMartian(bob);vod.addMartian(tiny);
		return vod;
	}
	
	public static MartianManager managerWithOutO() {
		MartianManager vod = new MartianManager();
		RedMartian it = new RedMartian(22,1,2);
		GreenMartian sar = new GreenMartian(16, 4);
		RedMartian bob = new RedMartian(4,16,4);
		GreenMartian tiny = new GreenMartian(100, 7);
		vod.addMartian(it); vod.addMartian(sar); vod.addMartian(bob);vod.addMartian(tiny);
		return vod;
	}
	
	public static String formatedArray(ArrayList<Martian> list) {
		String part1 = "Martian:\n";
		String part2 = "\nTeleporters:\n";
		for(Martian m: list) {
			part1 += m.toString() + "\n";
			if(m instanceof Teleporter) {
				part2 += m.toString() + "\n";
			}
		}
		String last = part1 + part2;
		return last;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
