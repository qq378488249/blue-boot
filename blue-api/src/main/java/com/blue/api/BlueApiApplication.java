package com.blue.api;

import com.blue.dao.entity.a.A;
import com.blue.dao.mapper.UserMapper;
import com.blue.utils.tools.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;

import static com.sun.media.jfxmedia.track.Track.Encoding.CUSTOM;

@SpringBootApplication
@ComponentScan(basePackages={"com.blue"})
//@ComponentScan(basePackages={"com.blue.api.controller","com.blue.dao.entity","com.blue.dao.mapper"})
@MapperScan("com.blue.dao.mapper")
public class BlueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueApiApplication.class, args);

		System.out.println("blue-api启动成功");
		A a = new A();
		a.setName("asg");
		a.setId(654);
		System.out.println(a.toString());

		System.out.println("测试utils下的类："+StringUtils.isNull(null));
		System.out.println("测试utils下的类："+StringUtils.isNull(null,null));
	}

}
