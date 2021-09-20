package com.example.demo;

import org.springframework.batch.item.ItemProcessor;

public class ProcProcess implements ItemProcessor<Syain,Syain> {

	@Override
	public Syain process(Syain syain) throws Exception {
	    final String id = syain.getId();
	    final String romaji = syain.getRomaji().toUpperCase();
	    final Syain s1 = new Syain(id,romaji);
		return s1;
	}
}
