package com.Util;

public class R {
	int code;
	String msg;
	int count;
	Object data;
	
	public R(){}
	
	public R(int code, String msg, int count, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	public int getCount() {
		return count;
	}
	public Object getData() {
		return data;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
