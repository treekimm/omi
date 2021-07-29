package com.tree.omi.programmers;

import java.util.HashMap;

public class hashProb1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<String, Integer>();
        HashMap<String, Integer> completionMap = new HashMap<String, Integer>();
        String answer = "";
        for(String p : participant) {
        	participantMap.put(p,participantMap.getOrDefault(p, 0)+1);
        }
        for(String c : completion) {
        	participantMap.put(c,completionMap.get(c)-1);
        }
        
        for(String key : participantMap.keySet()) {
        	if(participantMap.get(key) == 1) {
        		answer = key;
        		break;
        	}
        }
        
        return answer;
    }
	//전화번호 목록
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String,Integer> phoneMap = new HashMap<String,Integer>();
        
        for(String p : phone_book) {
        	phoneMap.put(p, p.length());
        }
        
        for(String key : phoneMap.keySet()) {
        	for(String p : phone_book) {
        		if(key.startsWith(p)) {
        			return answer = false;
        		}
        	}
        	
        }
        
        return answer;
    }
}
