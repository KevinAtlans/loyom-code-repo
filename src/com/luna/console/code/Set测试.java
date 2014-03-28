package com.luna.console.code;

import java.util.HashSet;
import java.util.Set;

import com.loyom.utils.Print;

public class Set测试 {

	public static void main(String[] args) {

		Set<String> sets = new HashSet<String>();
		sets.add("String");
		sets.add("Int");
		sets.add("String");

		Print.println(sets.size());
	}
}
