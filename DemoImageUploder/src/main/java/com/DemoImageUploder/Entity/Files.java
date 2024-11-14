package com.DemoImageUploder.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="files")
public class Files 
{  
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;

    @Lob
    @Column(name="imageData",length=5000)
    private byte[] imageData;
    
    
	public Files() 
	{
	}

	public Files(Integer id, String name, String type, byte[] imageData)
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageData = imageData;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public byte[] getImageData() 
	{
		return imageData;
	}

	public void setImageData(byte[] imageData) 
	{
		this.imageData = imageData;
	}
}
