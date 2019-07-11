package interview;

import java.util.LinkedList;
import java.util.List;

public class AmazonMergeLists {

	public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2){
		if(list1 != null || list2 != null) {
			List<Integer> mergedList = new LinkedList<Integer>();
			int i = 0;
			int j = 0;
			int list1Size = list1 == null ? 0 : list1.size();
			int list2Size = list2 == null ? 0 : list2.size();
			while (i < list1Size || j < list2Size) {
				if (i < list1Size && j < list2Size) {
					if (list1.get(i) <= list2.get(j)) {
						mergedList.add(list1.get(i++));
					} else {
						mergedList.add(list2.get(j++));
					}
				} else if (i < list1Size) {
					mergedList.add(list1.get(i++));
				} else {
					mergedList.add(list2.get(j++));
				}
			}
			return mergedList;
		}
		return null;
	}
}
