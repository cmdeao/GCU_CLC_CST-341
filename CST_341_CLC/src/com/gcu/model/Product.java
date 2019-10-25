package com.gcu.model;

import com.gcu.business.ProductInterface;

public class Product implements ProductInterface{

	private String songName;
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public float getSongLength() {
		return songLength;
	}
	public void setSongLength(float songLength) {
		this.songLength = songLength;
	}
	public String getSongGenre() {
		return songGenre;
	}
	public void setSongGenre(String songGenre) {
		this.songGenre = songGenre;
	}
	
	public void init()
	{
		System.out.println("Product INIT method!");
	}
	
	public void destroy()
	{
		System.out.println("Product DESTROY method!");
	}
	
	private String artistName;
	private String albumName;
	private float songLength;
	private String songGenre;
}
