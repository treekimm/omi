package com.tree.omi.programmers;

import java.util.ArrayList;
import java.util.List;

public class stackProb01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s = new Solution();
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		int[] a = {};
		
		a = s.solution(progresses,speeds);
		
	}
	
	
}

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		List temp = new ArrayList<Integer>();
		int progresse = 0;
		int speed = 0;
		int deployCnt = 0;
		int standardPrgrRequireDay = 0;
		int earlyEndPrgrRequireDay = 0;
		for(int i = 0 ; i < progresses.length ;) {
			progresse = progresses[i];
			speed = speeds[i];
			
			while(progresse < 100) {
				progresse += speed;
				standardPrgrRequireDay++;
			}
			deployCnt++;
			
			for(int j = i+deployCnt; j <progresses.length; j++) {
				progresse = progresses[j];
				speed = speeds[j];
				
				while(progresse < 100) {
					progresse += speed;
					earlyEndPrgrRequireDay++;
				}
				
				if(standardPrgrRequireDay<earlyEndPrgrRequireDay) {
					break;
				}
				deployCnt++;
				earlyEndPrgrRequireDay=0;
			}
			temp.add(deployCnt);
			i = i+deployCnt;
			deployCnt=0;
			standardPrgrRequireDay=0;
			earlyEndPrgrRequireDay=0;
		}
		answer = new int[temp.size()];
		for(int i = 0 ; i < temp.size(); i++)
            answer[i] = Integer.parseInt(temp.get(i).toString());
		return answer;
	}
}