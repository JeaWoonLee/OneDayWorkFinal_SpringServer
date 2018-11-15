package com.lx.odw.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

public class Util {

	public static String getUplodaPath(String base64Str, HttpServletRequest request, String seekerId) {
		//Path
		String path = request.getSession().getServletContext().getRealPath("/resources/profile/");
		String filePath = path + "/" + seekerId + ".png";
		File outputfile = new File(filePath);
		if(!outputfile.exists()) {
			outputfile.mkdirs();
		}
		
		//String base64Image = base64Str.split(",")[1];
		byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Str);
		try {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
			
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "resources/profile/" + seekerId + ".png";
	}
}
