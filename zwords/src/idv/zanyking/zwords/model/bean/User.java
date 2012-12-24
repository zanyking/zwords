/**User.java
 * 2012/12/23
 * 
 */
package idv.zanyking.zwords.model.bean;

/**
 * @author Ian YT Tsai(Zanyking)
 *
 */
public class User {
	
	private String name;
	private String password;
	private String cookies;
	private boolean anonymous;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	public String getCookies() {
		return cookies;
	}
	public void setCookies(String cookies) {
		this.cookies = cookies;
	}
	
}
