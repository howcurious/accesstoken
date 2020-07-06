package cn.nbbandxdd.accesstoken.common.wechat.accesstoken;

import lombok.Data;

@Data
public class AccessTokenDTO {

	private String access_token;
	
	private String expires_in;
	
	private String errcode;
	
	private String errmsg;
}
