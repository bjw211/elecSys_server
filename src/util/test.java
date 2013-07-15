package util;

import com.google.zxing.qrcode.encoder.QRCode;

public class test {
	
	public static void main(String[] args) {
		new CDQR().encode("100@aaaa");
		System.out.println("success");
	}

}
