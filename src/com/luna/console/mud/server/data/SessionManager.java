package com.luna.console.mud.server.data;

import java.util.Map;


import static com.google.common.collect.Maps.newHashMap;

public class SessionManager {

	public static Map<Long,SessionData> session = newHashMap();
	
	public static SessionData getSession(Long sessionId){
		return session.get(sessionId);
	}
	
	public static Long getSessionId(){
		Long sessionId = (long) (Math.random()*100000000);
		if(session.get(sessionId) != null){
			return getSessionId();
		}
		session.put(sessionId, new SessionData());
		return sessionId;
	}
}
