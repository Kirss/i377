package test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounterListener implements HttpSessionListener {

    private static int totalActiveSessions=0;
   

    public void sessionCreated(HttpSessionEvent event) {
        totalActiveSessions++;
    }

	
    public void sessionDestroyed(HttpSessionEvent event) {
    	totalActiveSessions--;
    }
    
    public static int getTotalActiveSessions() {
    	return totalActiveSessions;
    }
	
}
