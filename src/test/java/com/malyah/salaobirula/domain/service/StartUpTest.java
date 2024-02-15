package com.malyah.salaobirula.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salaobirula.SalaobirulaApplication;

@ExtendWith(MockitoExtension.class)
public class StartUpTest {

	@InjectMocks
	private SalaobirulaApplication salaobirulaApplication;
	
	@Test
	void contextLoads() {
		assertThat(salaobirulaApplication).isNotNull();
	}
	
	@Test
	void main() {
		SalaobirulaApplication.main(new String[] {});
	}
}
