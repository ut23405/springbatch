package com.example.demo;

public class Syain {
	private String id;
	private String romaji;

	public Syain() {
	}

	public Syain(String id, String romaji) {
		this.id = id;
		this.romaji = romaji;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRomaji() {
		return romaji;
	}

	public void setRomaji(String romaji) {
		this.romaji = romaji;
	}

	@Override
	public String toString() {
		return "ID=: " + id + ", romaji=: " + romaji;
	}

}
