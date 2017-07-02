package cn.it.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.it.shop.model.FileImage;

/**
 * ʵ���ļ��ϴ�
 * @author Administrator
 *
 */
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	@Value("#{prop.filePath+prop.filePath}")
	private String filePath;
	@Value("#{prop.filePath+prop.bankPath}")
	private String bankPath;
	
	
//	public void setFilePath(String filePath) {
//		System.out.println("filePath:"+filePath);
//		this.filePath = filePath;
//	}
	public String[] getBankImage(){
		return new File(bankPath).list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".gif");
			}
		});
	}
	//1��ͨ���ļ�����ȡ��չ��
	public String getFileExt(String filename){
		return FilenameUtils.getExtension(filename);
	}
	//����UUId���������Ϊ�µ��ļ���
	public String newFileName(String filename){
		String ext = getFileExt(filename);
		return UUID.randomUUID().toString() + "." + ext;
	}
	
	/* (non-Javadoc)
	 * @see cn.it.shop.util.FileUpload#uploadFile(cn.it.shop.model.FileImage)
	 */
	public String uploadFile(FileImage fileImage){
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			fileImage.getFile().delete();
		}
	}
}
