package com.qihui.cachedemo;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CachedemoApplication {

	public static void main(String[] args) {
		//阿里序列化  打开autotype功能  https://github.com/alibaba/fastjson/wiki/enable_autotype
		ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
		SpringApplication.run(CachedemoApplication.class, args);
	}
}
