package task8_2;

class MyEncryption{
	private String password;
	public void setPasswd(String passwd){
		password = passwd;
	}
	public String EncodeStr(String s){
		char[] c = s.toCharArray();
		char[] p = password.toCharArray();
		for(int i=0,j=0;i<c.length;i++,j++){
			if(j>=p.length) j=0;
			c[i] = (char)(c[i]^p[j]);
		}
		return new String(c);
	}
	
	public String DecodeStr(String s){
		return EncodeStr(s);
	}
}

public class Task8_2 {
	public static void main(String[] args) {
		MyEncryption me = new MyEncryption();
		String s = "My name is LinFengxiang";
		me.setPasswd("wbgsn");
		String encodeString = me.EncodeStr(s);
		System.out.println("加密前原文:"+s);
		System.out.println("加密后的内容为:"+encodeString);
		String decodeStr = me.DecodeStr(encodeString);
		System.out.println("解密后的原文为:"+decodeStr);
	}
}
