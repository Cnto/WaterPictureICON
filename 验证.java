package com.iamdoc.util;

import java.util.regex.Pattern;

/**
 * ���򹤾��� �ṩ��֤���䡢�ֻ��š��绰���롢���֤���롢���ֵȷ���
 */
public final class RegexUtils {

	/**
	 * ��֤Email
	 * 
	 * @param email
	 *            email��ַ����ʽ��zhangsan@sina.com��zhangsan@xxx.com.cn��xxx�����ʼ�������
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkEmail(String email) {
		String regex = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
		if( Pattern.matches(regex, email)){
			if(email.contains("..")){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	/**
	 * ������֤��
	 * 
	 * @param captcha
	 *            ����ʽ��6λ����
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkCaptcha(String captcha) {
		String regex = "\\d{6}";
		return Pattern.matches(regex, captcha);
	}

	/**
	 * ��֤���֤����
	 * 
	 * @param idCard
	 *            �������֤����15λ��18λ�����һλ���������ֻ���ĸ
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkIdCard(String idCard) {
		String regex = "[1-9]\\d{13,16}[xX0-9]{1}";
		return Pattern.matches(regex, idCard);
	}

	/**
	 * ��ִ֤ҵ֤�����
	 * 
	 * @param
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkCertificateCard(String certificateCard,int post) {
		if(1<=post&&post<=4){
			String regex = "[1-2][1-4][0-9][1-6]\\d{11}";
			return Pattern.matches(regex, certificateCard);
		}else if(6<=post&&post<=10){
			String regex2 = "\\d{12}";
			return Pattern.matches(regex2, certificateCard);
		}else if(11<=post){
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * ��֤�ֻ����루֧�ֹ��ʸ�ʽ��+86135xxxx...���й��ڵأ���+00852137xxxx...���й���ۣ���
	 * 
	 * @param mobile
	 *            �ƶ�����ͨ��������Ӫ�̵ĺ����
	 *            <p>
	 *            �ƶ��ĺŶΣ�134(0-8)��135��136��137��138��139��147��Ԥ������TD��������
	 *            ��150��151��152��157��TDר�ã���158��159��187��δ���ã���188��TDר�ã�
	 *            </p>
	 *            <p>
	 *            ��ͨ�ĺŶΣ�130��131��132��155��156�������ר�ã���185��δ���ã���186��3g��
	 *            </p>
	 *            <p>
	 *            ���ŵĺŶΣ�133��153��180��δ���ã���189��177
	 *            </p>
	 *            <p>
	 *            ������Ӫ�̵ĺŶΣ�170
	 *            </p>
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkMobile(String mobile) {
		String regex = "(\\+\\d+)?1[34578]\\d{9}$";
		return Pattern.matches(regex, mobile);
	}

	/**
	 * ��֤�̶��绰����
	 * 
	 * @param phone
	 *            �绰���룬��ʽ�����ң��������绰���� + ���ţ����д��룩 + �绰���룬�磺+8602085588447
	 *            <p>
	 *            ���ң������� ���� ����ʶ�绰����Ĺ��ң��������ı�׼���ң����������롣�������� 0 �� 9 ��һλ���λ���֣�
	 *            ����֮���ǿո�ָ��Ĺ��ң����������롣
	 *            </p>
	 *            <p>
	 *            ���ţ����д��룩������ܰ���һ�������� 0 �� 9 �����֣���������д������Բ���š���
	 *            �Բ�ʹ�õ�������д���Ĺ��ң�����������ʡ�Ը������
	 *            </p>
	 *            <p>
	 *            �绰���룺������� 0 �� 9 ��һ����������
	 *            </p>
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkPhone(String phone) {
		String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
		return Pattern.matches(regex, phone);
	}

	/**
	 * ��֤�������������͸�������
	 * 
	 * @param digit
	 *            һλ���λ0-9֮�������
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkDigit(String digit) {
		String regex = "^-?\\d+$";
		return Pattern.matches(regex, digit);
	}

	/**
	 * ��֤�����͸�����������������������������
	 * 
	 * @param decimals
	 *            һλ���λ0-9֮��ĸ��������磺1.23��233.30
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkDecimals(String decimals) {
		String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
		return Pattern.matches(regex, decimals);
	}

	/**
	 * ��֤�հ��ַ�
	 * 
	 * @param blankSpace
	 *            �հ��ַ����������ո�\t��\n��\r��\f��\x0B
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkBlankSpace(String blankSpace) {
		String regex = "\\s+";
		return Pattern.matches(regex, blankSpace);
	}

	/**
	 * ��֤����
	 * 
	 * @param chinese
	 *            �����ַ�
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkChinese(String chinese) {
		String regex = "^[\u4E00-\u9FA5]+$";
		return Pattern.matches(regex, chinese);
	}

	/**
	 * ��֤���ڣ������գ�
	 * 
	 * @param birthday
	 *            ���ڣ���ʽ��1992-09-03����1992.09.03
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkDay(String day) {
		String regex = "[1-9]{1}\\d{3}([-./])\\d{1,2}\\1\\d{1,2}";
		return Pattern.matches(regex, day);
	}

	/**
	 * ��֤URL��ַ
	 * 
	 * @param url
	 *            ��ʽ��http://blog.csdn.net:80/xyang81/article/details/7705960? ��
	 *            http://www.csdn.net:80
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkURL(String url) {
		// String regex =
		// "(http(s)?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		return Pattern.matches(regex, url);
	}

	/**
	 * ƥ���й���������
	 * 
	 * @param postcode
	 *            ��������
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkPostcode(String postcode) {
		String regex = "[1-9]\\d{5}";
		return Pattern.matches(regex, postcode);
	}

	/**
	 * ƥ��IP��ַ(��ƥ�䣬��ʽ���磺192.168.1.1��127.0.0.1��û��ƥ��IP�εĴ�С)
	 * 
	 * @param ipAddress
	 *            IPv4��׼��ַ
	 * @return ��֤�ɹ�����true����֤ʧ�ܷ���false
	 */
	public static boolean checkIpAddress(String ipAddress) {
		String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
		return Pattern.matches(regex, ipAddress);
	}

	public static void main(String[] args) {
		System.out.println(RegexUtils.checkDay("1900-01-01"));
	}

}
