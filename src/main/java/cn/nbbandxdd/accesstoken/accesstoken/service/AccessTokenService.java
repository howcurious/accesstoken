package cn.nbbandxdd.accesstoken.accesstoken.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.nbbandxdd.accesstoken.common.wechat.accesstoken.AccessTokenGenerator;

@RestController
@RequestMapping("/accesstoken")
public class AccessTokenService {

	@Autowired
	private AccessTokenGenerator accessTokenGenerator;
	
	@GetMapping("/get")
	public String get() {
		
		return accessTokenGenerator.get();
	}
}
