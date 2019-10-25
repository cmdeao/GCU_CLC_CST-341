package com.gcu.business;

public interface ProductInterface 
{
	public void setSongName(String songName);
	public void setArtistName(String artistName);
	public void setAlbumName(String albumName);
	public void setSongLength(float songLength);
	public void setSongGenre(String songGenre);
	
	public String getSongName();
	public String getArtistName();
	public String getAlbumName();
	public float getSongLength();
	public String getSongGenre();
	
	public void init();
	public void destroy();
}
