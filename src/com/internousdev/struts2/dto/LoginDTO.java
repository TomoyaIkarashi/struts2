/**
 *
 */
package com.internousdev.struts2.dto;

/**
 * @author internousdev
 *
 */
public class LoginDTO {
	private int id;
	private String name;
	private String password;

	public int getid(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name =name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

}