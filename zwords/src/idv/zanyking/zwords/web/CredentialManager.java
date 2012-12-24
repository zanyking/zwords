/**UserManager.java
 * 2012/12/23
 * 
 */
package idv.zanyking.zwords.web;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import idv.zanyking.zwords.model.UserDAO;
import idv.zanyking.zwords.model.bean.User;

/**
 * @author Ian YT Tsai(Zanyking)
 *
 */
public class CredentialManager {

	private UserDAO userDAO = new UserDAO();
	private User user;
	
	
	public UserDAO getUserDAO(){
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	/**
	 * 
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password){
		User tempUser = getUserDAO().findUserByName(userName);
		if(tempUser!=null && tempUser.getPassword().equals(password)){
			user = tempUser;
		}else{
			user = null;
		}
	}
	
	
	
	
	public void logOff(){
		user = null;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isAuthenticated(){
		return user != null;
	}
	/**
	 * 
	 * @return
	 */
	public User getUser(){
		return user;
	}
	
	/**
	 * 
	 * can be removed 
	 * @param zkSession
	 * @return
	 */
	public static CredentialManager getInstance(HttpSession session){
		synchronized (session) {
			CredentialManager manager = (CredentialManager) session.getAttribute("UserCredentialManager");
			if(manager==null){
				manager = new CredentialManager();
				session.setAttribute("UserCredentialManager", manager);
			}
			return manager;	
		}
	}
	private static final String COOKIE_CREDENTIAL = "COOKIE_CREDENTIAL";
	public void loginByCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		for(Cookie c : cookies){
			if(COOKIE_CREDENTIAL.equals(c.getName())){
				user = getUserDAO().findUserByCookie(c.getValue());
				cookie = c;
				break;
			}
		}
		String newKey = genNewCookie();
		user.setCookies(newKey );
		cookie.setValue(newKey);
		response.addCookie(cookie);
		
				
	}
	private static String genNewCookie() {
		return UUID.randomUUID().toString();
	}
}
