package com.picwater.demo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ͼƬ�����࣬ ͼƬˮӡ������ˮӡ�����ţ����׵�
 * 
 * @author Carl He
 */
public final class Demo {
	/** ͼƬ��ʽ��JPG */
	private static final String PICTRUE_FORMATE_JPG = "jpg";

	private Demo() {
	}

	/**
	 * ���ͼƬˮӡ
	 * 
	 * @param targetImg
	 *            Ŀ��ͼƬ·�����磺C://myPictrue//1.jpg
	 * @param waterImg
	 *            ˮӡͼƬ·�����磺C://myPictrue//logo.png
	 * @param x
	 *            ˮӡͼƬ����Ŀ��ͼƬ����ƫ���������x<0, �������м�
	 * @param y
	 *            ˮӡͼƬ����Ŀ��ͼƬ�ϲ��ƫ���������y<0, �������м�
	 * @param alpha
	 *            ͸����(0.0 -- 1.0, 0.0Ϊ��ȫ͸����1.0Ϊ��ȫ��͸��)
	 */
	public final static void pressImage(String targetImg, String waterImg,
			int x, int y, float alpha) {
		try {
			File file = new File(targetImg);
			Image image = ImageIO.read(file);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bufferedImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);

			Image waterImage = ImageIO.read(new File(waterImg)); // ˮӡ�ļ�
			int width_1 = waterImage.getWidth(null);
			int height_1 = waterImage.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));

			int widthDiff = width - width_1;
			int heightDiff = height - height_1;
			if (x < 0) {
				x = widthDiff / 2;
			} else if (x > widthDiff) {
				x = widthDiff;
			}
			if (y < 0) {
				y = heightDiff / 2;
			} else if (y > heightDiff) {
				y = heightDiff;
			}
			g.drawImage(waterImage, x, y, width_1, height_1, null); // ˮӡ�ļ�����
			g.dispose();
			ImageIO.write(bufferedImage, PICTRUE_FORMATE_JPG, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �������ˮӡ
	 * 
	 * @param targetImg
	 *            Ŀ��ͼƬ·�����磺C://myPictrue//1.jpg
	 * @param pressText
	 *            ˮӡ���֣� �磺�й�֤ȯ��
	 * @param fontName
	 *            �������ƣ� �磺����
	 * @param fontStyle
	 *            ������ʽ���磺�����б��(Font.BOLD|Font.ITALIC)
	 * @param fontSize
	 *            �����С����λΪ����
	 * @param color
	 *            ������ɫ
	 * @param x
	 *            ˮӡ���־���Ŀ��ͼƬ����ƫ���������x<0, �������м�
	 * @param y
	 *            ˮӡ���־���Ŀ��ͼƬ�ϲ��ƫ���������y<0, �������м�
	 * @param alpha
	 *            ͸����(0.0 -- 1.0, 0.0Ϊ��ȫ͸����1.0Ϊ��ȫ��͸��)
	 */
	public static void pressText(String targetImg, String pressText,
			String fontName, int fontStyle, int fontSize, Color color, int x,
			int y, float alpha) {
		try {
			File file = new File(targetImg);
			File fileoutput = new File("C:/Users/yyhl002/Desktop/1234567.jpg");
			Image image = ImageIO.read(file);
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			BufferedImage bufferedImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setColor(color);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			 // ����ˮӡ��ת 
            g.rotate(Math.toRadians(45), 
                    (double) bufferedImage.getWidth() / 2, (double) bufferedImage 
                            .getHeight() / 2); 
			//���¡���ҽ������
			Graphics2D g1 = bufferedImage.createGraphics();
			g1.drawImage(image, 0, 0, width, height, null);
			g1.setFont(new Font(fontName, fontStyle, 16));
			g1.setColor(color);
			g1.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			//���¡�www.yunyi001.com������
			Graphics2D g2 = bufferedImage.createGraphics();
			g2.drawImage(image, 0, 0, width, height, null);
			g2.setFont(new Font(fontName, fontStyle, 12));
			g2.setColor(color);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			
			int width_1 = fontSize * getLength(pressText);
			int height_1 = fontSize;
			int widthDiff = width - width_1;
			int heightDiff = height - height_1;
			if (x < 0) {
				x = widthDiff / 2;
			} else if (x > widthDiff) {
				x = widthDiff;
			}
			if (y < 0) {
				y = heightDiff / 2;
			} else if (y > heightDiff) {
				y = heightDiff;
			}
			//���¡���ҽ������
			g1.drawString("��ҽ", width-110, height-17);
			g1.dispose();
			//���¡�www.yunyi001.com������
			g2.drawString("www.yunyi001.com", width-110, height-5);
			g2.dispose();
			g.drawString(pressText, x, y + height_1);
			g.dispose();
			ImageIO.write(bufferedImage, file.getName().substring(file.getName().indexOf(".")+1), fileoutput);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ�ַ����ȣ�һ��������Ϊ 1 ���ַ�, һ��Ӣ����ĸ��Ϊ 0.5 ���ַ�
	 * 
	 * @param text
	 * @return �ַ����ȣ��磺text="�й�",���� 2��text="test",���� 2��text="�й�ABC",���� 4.
	 */
	public static int getLength(String text) {
		int textLength = text.length();
		int length = textLength;
		for (int i = 0; i < textLength; i++) {
			if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
				length++;
			}
		}
		return (length % 2 == 0) ? length / 2 : length / 2 + 1;
	}

	

	public static void main(String[] args) throws IOException {
//		pressImage("C://pic//jpg", "C://pic//test.gif", 5000, 5000, 0f);
		pressText("C:/Users/yyhl002/Desktop/123456.jpg", "��ҽ��ҽ��ҽ��ҽ��ҽ��ҽ��ҽ", "΢���ź�", 0, 40,
				Color.black, -1, -1, 0.6f);
//		pressText("C:/Users/yyhl002/Desktop/123456.jpg", "����֮ӡ", "΢���ź�", 0, 40,
//				Color.white, -1, -1, 0.6f);
//		resize("C://pic//4.jpg", 1000, 500, true);
	}
}