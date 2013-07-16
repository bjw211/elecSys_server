package util;

/**
 * ����: CDQR
 * ����: �������ڶ�ά������ɺͽ��룬ʹ��google�Ŀ�ԴAPI�ϳ�
 * ����: JAVA
 * ����޸�ʱ��: 2013��07��15
 * @author �����
 */ 

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class CDQR {
	
	
	private BitMatrix byteMatrix;
	private File file;
	private Reader reader;
	private BufferedImage image;
	private LuminanceSource source;
	private BinaryBitmap bitmap;
	private Result result;
	private Hashtable<DecodeHintType, String> hints;
	private String resultStr;
	
	
		/**
	������ * ��������
	������ * 
	������ * @param String str
	������ * @return QR code image
		* ����,�����ά�����ݣ����浽��Ӧ��·�����ɵĶ�ά��png
	������ *
	������ */
	public void encode(String str) {

System.out.println(str);		
		try {
			String s[] = new String[5];
			s = str.split("@");		
			String path = "d://workspace/elecSys/QRimages/"+s[0]+".png";
//			String path = "./QRimages/"+s[0]+ ".png";
			System.out.println(path);
			byteMatrix = new MultiFormatWriter().encode(new String(s[1].getBytes("UTF-8"),"iso-8859-1"),
					BarcodeFormat.QR_CODE, 200, 200);
			file = new File(path);
			MatrixToImageWriter.writeToFile(byteMatrix, "png", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		/**
	������ * ��������
	������ * 
	������ * @param QR code images
	������ * @return String str
		* ����,�����ά��ͼƬ�������Ӧ�Ķ�ά�������
	������ *
	������ */
	public void decode() {
		try {
			reader = new MultiFormatReader();
			String path = "./QRimages/3.png";;
			file = new File(path);
			try {
				image = ImageIO.read(file);
				if (image == null) {
					System.out.println("Could not decode image");
				}
				source = new BufferedImageLuminanceSource(image);
				bitmap = new BinaryBitmap(new HybridBinarizer(source));
				hints = new Hashtable<DecodeHintType, String>();
				hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
				result = new MultiFormatReader().decode(bitmap, hints);
				resultStr = result.getText();
				System.out.println(resultStr);

			} catch (IOException ioe) {
				System.out.println(ioe.toString());
			} catch (ReaderException re) {
				System.out.println(re.toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
		/**
	������ * ��������
	������ * 
	������ * @param id  String str
	������ * @return QR code image
		* ���ڲ���	
	������ *
	������ */
	
//	public void run(){
//		String str ="7@�豸��:7,�豸����:7,�豸����:��ѹ��,�豸���ŵ�ַ:7";
//		encode(str);
//		decode();
//	}
//	
//	public static void main(String[] args) {
//		new CDQR().run();
//	}
	
}
