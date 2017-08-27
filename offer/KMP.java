package offer;

public class KMP {
	private int[] table;
	private char[] pattern;
	
	public KMP(String pattern) {
		this.pattern = pattern.toCharArray();
		this.table = new int[pattern.length() < 2 ? 2 : pattern.length()];
	}
	
	public int[] getNext(String b) {
		int len = b.length();
		int j = 0;
		
		int[] next = new int
	}
	
	private void getNext() {
		int len = pattern.length;
		table[0] = -1;
		
		int k = -1;
		int j = 0;
		while(j < len - 1) {
			if(k == -1 || pattern[j] == pattern[k]) {
				k++;
				j++;
				if(pattern[j] != pattern[k])
					table[j] = k;
				else
					table[j] = table[k];
				
			}
			else {
				k = table[k];
			}
		}
	}
	
	public int kmpSearch(String str) {
		int slen = str.length();
		int plen = pattern.length;
		char[] s = str.toCharArray();
		
		int i = 0, j = 0;
		while( i < slen && j < plen) {
			if(j == -1 || s[i] == pattern[j]) {
				//j == -1意味着执行了j = table[0]即意味着比对了s[i] == s[0]不成立，故要把在s中index加1
				//s[i] == pattern[j]成立意味着当前匹配成功，要匹配下一位
				i++;
				j++;
			} else {
				j = table[j];
			}
		}
		
		if(j == plen)
			return i - j;
		else
			return -1;
	}
}













