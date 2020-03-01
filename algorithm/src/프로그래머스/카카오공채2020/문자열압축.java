package 프로그래머스.카카오공채2020;

public class 문자열압축 {
	public static void main(String[] args) {
		System.out.println(solution("a"));
	}
    public static int solution(String s) {
    	StringBuilder sb = new StringBuilder(s);
        int answer = sb.length();
        for(int i=1; i <sb.length(); i++ ) {
        	int length = sb.length();
        	int front = 0;
        	int rear = i;
        	StringBuilder tempString1 = new StringBuilder(sb.substring(front, rear));
        	front += i;
        	int count = 0;
        	while(front < sb.length()) {
        		rear = front +i <= sb.length() ? front+i : sb.length();
            	StringBuilder tempString2 = new StringBuilder(sb.substring(front, rear));
            	
            	if(tempString1.toString().equals(tempString2.toString())) {
            		count++;               	
            	}else if(count != 0) {
            		length -= count*i;
            		length += (""+count).length();
            		count = 0;
            	}
        		tempString1 = new StringBuilder(tempString2.toString());
            	front += i;
        	}
        	 if(count != 0) {
         		length -= count*i;
         		length += (""+count).length();
         		count = 0;
         	}
        	answer = answer < length ? answer : length;
        }
        
        return answer;
    }
}
