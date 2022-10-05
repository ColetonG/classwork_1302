package prob1;

import java.util.Comparator;

public class MartianVolumeComparator implements Comparator<Martian>{
	@Override
	public int compare(Martian m1, Martian m2) {
		if(m1.getVolume() == m2.getVolume()){
			return Integer.compare(m1.getId(), m2.getId());
		}
		else {
			return Integer.compare(m1.getVolume(), m2.getVolume());
		}
	}
}
