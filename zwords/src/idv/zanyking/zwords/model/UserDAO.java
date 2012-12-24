/**UserDAO.java
 * 2012/12/23
 * 
 */
package idv.zanyking.zwords.model;

import idv.zanyking.zwords.model.bean.User;

/**
 * @author Ian YT Tsai(Zanyking)
 *
 */
public class UserDAO {

	private static final User IAN;
	static{
		IAN = new User();
		IAN.setName("ian");
		IAN.setPassword("ian");
	}
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public User findUserByName(String userName) {
		if(IAN.getName().equalsIgnoreCase(userName)){
			return IAN;
		}
		return null;
	}

	public User findUserByCookie(String cookie) {
		User user = new User();
		user.setName("guest");
		user.setCookies(cookie);
		user.setAnonymous(true);
		return user;
	}
	
	
	
	

}
