package com.kk99corn.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RedisControllerTest {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Test
	void redisTest() {
		ValueOperations<String, String> vop = redisTemplate.opsForValue();
		vop.set("yellow", "banana");
		vop.set("red", "apple");
		vop.set("green", "watermelon");

		String v1 = vop.get("yellow");
		assertThat(v1).isEqualTo("banana");

		String v2 = vop.get("red");
		assertThat(v2).isEqualTo("apple");

		String v3 = vop.get("green");
		assertThat(v3).isNotEqualTo("apple");

		redisTemplate.opsForValue().getAndDelete("yellow");
		redisTemplate.opsForValue().getAndDelete("red");
		redisTemplate.opsForValue().getAndDelete("green");
	}
}
