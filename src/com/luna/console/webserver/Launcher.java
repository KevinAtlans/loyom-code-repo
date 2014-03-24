package com.luna.console.webserver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.loyom.utils.Print;

public class Launcher {

	public static void main(String[] args) throws Exception {

		// MyWebServer server = new MyWebServer();
		// server.startServer();
		// int[] a = Util.convertToInt("1,4,7,10,13");
		// for (int i : a) {
		// Print.print(i);
		// }
		// List<String> strs = Util
		// .fetchContent("<Line>1,4,7,10,13</Line><Line>0,3,6,9,12</Line><Line>2,5,8,11,14</Line><Line>1,3,7,11,13</Line><Line>1,5,7,9,13</Line><Line>1,4,6,10,13</Line><Line>1,4,8,10,13</Line><Line>1,3,6,9,13</Line><Line>1,5,8,11,13</Line><Line>0,3,7,11,14</Line><Line>2,5,7,9,12</Line><Line>0,4,6,10,12</Line><Line>2,4,8,10,14</Line><Line>0,4,7,10,12</Line><Line>2,4,7,10,14</Line><Line>0,4,8,10,12</Line><Line>2,4,6,10,14</Line><Line>1,5,6,11,13</Line><Line>1,3,8,9,13</Line><Line>0,5,6,11,12</Line>");
		//
		// String strss = "";
		// for (String str : strs) {
		// strss += (str + "|");
		// }
		// Print.println(strss);

		String[] strs = "L,I,G,M,A,L,H,I,G,K,L,J,C,I,S,K,L,G,M,E,J,F,L,I,S,C,G,A,E,I,L,A,D,L,J,B,M,E,L,G,D,S,E,I,F,M,B,H,L,I,D,S,E,J,C,K,M,G,F,L,A,H,E,S,I,K,B,M,G,D,L,F,I,A,L,H,E,K,G,D,M,J,C,S,F,K,H,L,I,B,K,G,M,S,E,B,J,H,F,K,D,I,C,M,B,G,D,W,J,C,H,A,K,F,D,I,B,M,J,E,H,C,K,F,B,J,D,E,M,F,H,C,K,H,J,E,M,B,F,K,C,J,H,M"
				.split(",");
		String s = "{";
		Set<String> a = new HashSet<String>();
		for (String str : strs) {
			a.add(str);
		}
		for (String str : a) {
			Print.print(str+",");
		}
	}
}
