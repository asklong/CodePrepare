
public class StringCompress {
	public static String compressString(String s) {
		char[] chars = s.toCharArray();
		//i is the index of a character
		//end is the index of a new different character
		int end = 0, len = chars.length;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<len; ){
			sb.append(chars[i]);
			end = i+1;
			while(end<len && chars[end]==chars[i]){
				++end;
			}
			if(end - i != 1){
				sb.append(end - i);
			}
			i = end;
		}
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.print(compressString("bbaaaccb"));
		
	}
}
