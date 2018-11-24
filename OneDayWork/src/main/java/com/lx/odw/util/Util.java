package com.lx.odw.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class Util {

	public static String getUplodaPath(MultipartFile seekerPhoto, HttpServletRequest request, String seekerId) throws IOException {
		//Path
		String path = request.getSession().getServletContext().getRealPath("/resources/profile/");
		File outputfile = new File(path);
		if(!outputfile.exists()) {
			outputfile.mkdirs();
		}
		String saveName = upLodaFile(path,seekerPhoto.getOriginalFilename(), seekerPhoto.getBytes());
		return "resources/profile/" + saveName;
	}

	private static String upLodaFile(String filePath, String seekerPhoto, byte[] bytes) throws IOException {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+seekerPhoto;
		File target = new File(filePath,savedName);
		FileCopyUtils.copy(bytes, target);
		return savedName;
	}
	
}
