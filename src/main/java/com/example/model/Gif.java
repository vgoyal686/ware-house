package com.example.model;

/*
Notice the @Transient annotation on the MultipartFile field.
This means that the field value will NOT be persisted to the database.
*/


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Gif {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Lob
private byte[] bytes;

@Transient
private MultipartFile file;

private String description;


private LocalDateTime dateUploaded = LocalDateTime.now();

private String username = "You";

private boolean favorite;

private String hash;

public Gif(){}

public Long getId()
{
	return id;
}

public void setId(Long id)
{
	this.id = id;
}

public byte[] getBytes()
{
	return bytes;
}

public void setBytes(byte[] bytes)
{
	this.bytes = bytes;
}

public MultipartFile getFile()
{
	return file;
}

public void setFile(MultipartFile file)
{
	this.file = file;
}

public String getDescription()
{
	return description;
}

public void setDescription(String description)
{
	this.description = description;
}

public LocalDateTime getDateUploaded()
{
	return dateUploaded;
}

public void setDateUploaded(LocalDateTime dateUploaded)
{
	this.dateUploaded = dateUploaded;
}

public String getUsername()
{
	return username;
}

public void setUsername(String username)
{
	this.username = username;
}

public boolean isFavorite()
{
	return favorite;
}

public void setFavorite(boolean favorite)
{
	this.favorite = favorite;
}

public String getHash()
{
	return hash;
}

public void setHash(String hash)
{
	this.hash = hash;
}


/* Getters, setters, and unrelated methods omitted for brevity */
}
