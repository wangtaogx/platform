package com.tao.sdk.module.user;

import com.tao.sdk.core.http.Result;

public class UserResultModel {
	public static class RegisterResult extends Result{
		public String userId;
		
	}
	public static class LoginResult extends Result{
		public String token;
	}
}
