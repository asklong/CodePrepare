
package Array;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumCoverageInterval {
	static class Pair{
		
		public Pair(Integer value, Integer pos) {
			super();
			this.value = value;
			this.pos = pos;
		}
		Integer value;
		Integer pos;
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		public Integer getPos() {
			return pos;
		}
		public void setPos(Integer pos) {
			this.pos = pos;
		}
		
	}
	public static int[] getMinRange(List<List<Integer>> lists){
		int[] res = new int[2];
		if(lists==null || lists.size()==0)return res;
		if(lists.size()==1){
			if(lists.get(0)==null){
				return res;
			}
			else{
				res[0] = lists.get(0).get(0);
				res[1] = lists.get(0).get(0);
				return res;
			}
		}
		//get the first element in each list to make a heap
		//the min and max is the range at first
		//each time we update the range by remove the min value of the heap, and add the value from the same array
		//until there is a array has no element
		//why we remove the min value, if we remove the other value, we add the next element of the same array
		//that will make the range is same or larger
		PriorityQueue<Pair> q = new PriorityQueue<Pair>((a,b)->{return a.getValue()-b.getValue();});
		Pair p = new Pair(null, null);
		Pair[] pairs = new Pair[lists.size()];
		for(int i=0; i<lists.size(); ++i){
			//if we checked all the arrays until one arrary there are no elements
			pairs[i] = new Pair(lists.get(0).remove(0),i);
			
		}
		int range = Integer.MAX_VALUE;
		while(true){
			//get the next value of minimum for replace
			
			
			int[] ms = getMinAndMax(pairs);
			if(pairs[ms[1]].getValue()-pairs[ms[0]].getValue() < range){
				range = pairs[ms[1]].getValue()-pairs[ms[0]].getValue();
				res[0] = pairs[ms[0]].getValue();
				res[1] = pairs[ms[1]].getValue();
			}
			//select the minimum value and the maxmum value as the range
			if(lists.get(pairs[ms[0]].getPos()).isEmpty()){
				return res;
			}
			lists.get(pairs[ms[0]].getPos()).remove(0);
			pairs[ms[0]] = new Pair(lists.get(pairs[ms[0]].getPos()).get(0), pairs[ms[0]].getPos());
		}
		
	}
	
	public static int[] getMinAndMax(Pair[] pairs){
		return null;
		
	}
}
