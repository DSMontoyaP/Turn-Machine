package model;

import java.util.Comparator;

public class CompareTurnTypesByDuration implements Comparator<TurnType>{

	/**
	 * *<b>Name:</b> compare. <br>
	 * This method compares turnType's by duration
	 * @return comparator
	 */
	public int compare(TurnType o1, TurnType o2) {
		int comparator;
		float a = o1.getDuration();
		float b = o2.getDuration();
		
		comparator =(int)(b-a);
		return comparator;
	}

}
