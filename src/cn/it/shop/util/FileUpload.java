package cn.it.shop.util;

import cn.it.shop.model.FileImage;

public interface FileUpload {

	public abstract String uploadFile(FileImage fileImage);
	
	public String[] getBankImage();

}