package cn.nbbandxdd.accesstoken.common.wechat.accesstoken;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.nbbandxdd.accesstoken.common.ICommonConstDefine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccessTokenGenerator {

	@Value("${wechat.app-id}")
	private String appid;

	@Value("${wechat.app-secret}")
	private String appsecret;

	private String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	
	@Autowired
	private RestTemplate textPlainRestTemplate;
	
	private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16, 0.9f, 1);
	
	@Scheduled(fixedDelay = 5400000L)
	public void set() {
		
		AccessTokenDTO dto = textPlainRestTemplate.getForObject(
			String.format(url, appid, appsecret), AccessTokenDTO.class);
		
		if (dto.getErrcode() != null && !"0".equals(dto.getErrcode())) {
			
			log.error("获取微信接口校验凭证失败，{}：{}。", dto.getErrcode(), dto.getErrmsg());
		}
		
		if (StringUtils.isNotBlank(dto.getAccess_token())) {
		
			map.put(ICommonConstDefine.WECHAT_API_ACCESSTOKEN_ACCESS_TOKEN, dto.getAccess_token());
		}
	}
	
	public String get() {
		
		return map.get(ICommonConstDefine.WECHAT_API_ACCESSTOKEN_ACCESS_TOKEN);
	}
}
