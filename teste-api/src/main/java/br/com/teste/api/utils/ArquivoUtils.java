package br.com.teste.api.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class ArquivoUtils {

	public static final String PREFIXO_IMAGE_64_PNG = "data:image/png;base64,";
	public static final String PREFIXO_IMAGE_64_JPEG = "data:image/jpeg;base64,";
	public static final String PREFIXO_IMAGE_64_PDF = "data:application/pdf;base64,";
	
	private String[] prefixos = new String [] {PREFIXO_IMAGE_64_PNG, PREFIXO_IMAGE_64_JPEG, PREFIXO_IMAGE_64_PDF};
	
	public byte[] convertImagem64ToByteArray(String image64) {
		try {
			
			for(String prefixo : prefixos) {
				image64 = image64.replace(prefixo, "");
			}
			
			return Base64.getDecoder().decode(new String(image64).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String convertByteArrayToImagem64(byte[] image) {
		return Base64.getEncoder().encodeToString(image);
	}
	
}