import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Decifra {
	public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		FileInputStream fis;
	    FileOutputStream fos;
	    CipherInputStream cis;
	    CipherOutputStream cos;
	    
	    fis = new FileInputStream("a.key");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    
	    FileInputStream fisT = new FileInputStream("a.cif");
	    Cipher c = Cipher.getInstance("AES");

	    CipherInputStream qq = new CipherInputStream(fisT, c);
	    fos = new FileOutputStream("b.txt");
	    
	 

	
	    //Dicas para decifrar
	    byte[] keyEncoded2 = new byte[16];//falta ler
	    ois.read(keyEncoded2);
	    
	    
	    
	    SecretKeySpec keySpec2 = new SecretKeySpec(keyEncoded2, "AES");
	    c.init(Cipher.DECRYPT_MODE, keySpec2);
	    
	    
	    byte[] b = new byte[16];  
	    int i = qq.read(b);
	    while (i != -1) {
	        fos.write(b, 0, i);
	        i = qq.read(b);
	    }
	    qq.close();
	    
	}
}

