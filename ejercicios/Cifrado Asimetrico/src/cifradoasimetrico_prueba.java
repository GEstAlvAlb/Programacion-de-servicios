import java.io.BufferedReader;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.FileReader; 
import java.math.BigInteger; 
import java.security.Key; 
import java.security.KeyFactory; 
import java.security.spec.RSAPublicKeySpec; 
import javax.crypto.Cipher; 

public class cifradoasimetrico_prueba  { 
	public static void main(String[] args)  { 
	try  { 
		BufferedReader br  = new BufferedReader(new FileReader(".\\nueva\\clave_publica"));
		BigInteger modulus  = new BigInteger(br.readLine()); 
		BigInteger exponente  = new BigInteger(br.readLine()); 
		RSAPublicKeySpec keyspec  = new RSAPublicKeySpec(modulus, exponente); KeyFactory keyfac  = KeyFactory.getInstance("RSA"); 
		Key public_key  = keyfac.generatePublic(keyspec); 
		Cipher desCipher  = Cipher.getInstance("RSA/ECB/PKCS1Padding"); 
		desCipher.init(Cipher.DECRYPT_MODE, public_key); 
		File inf  = new File(".\\nueva\\fichero_cifrado_con_RSA"); 
		FileInputStream is  = new FileInputStream(inf); 
		
		FileOutputStream os  = new FileOutputStream(".\\nueva\\fichero_descifrado_RSA.txt"); 
		
		byte[] buffer  = new byte[1024]; 
		int bytes_leidos  = is.read(buffer);
		while  (bytes_leidos  !=  -1)  { 
			os.write(desCipher.doFinal(buffer,  0, bytes_leidos));
			bytes_leidos  = is.read(buffer); 
		} 
		
		os.close(); 
		
	}catch  (Exception e)  { e.printStackTrace();}
} }

