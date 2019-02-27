import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

public class cifradoasimetrico {
	public static void main(String[] args) {
		try {
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			System.out.println("Generando par de claves");

			KeyPair keypair = keygen.generateKeyPair();
			System.out.println("Obteniendo objeto Cipher con cifrado RSA");
			Cipher desCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			System.out.println("Configurando Cipher para encriptar");
			desCipher.init(Cipher.ENCRYPT_MODE, keypair.getPrivate());
			System.out.println("Abriendo el fichero");

			File inf = new File("C:\\Users\\Alumnot\\Desktop\\Programacion-de-servicios\\ejercicios\\Cifrado Asimetrico\\nueva\\fichero_prueba.txt");
			FileInputStream is = new FileInputStream(inf);

			System.out.println("Abriendo el fichero cifrado");
			FileOutputStream os = new FileOutputStream(".\\nueva\\fichero_cifrado_con_RSA");
			System.out.println("Cifrando el fichero...");

			byte[] buffer = new byte[1024];
			int bytes_leidos = is.read(buffer);
			while (bytes_leidos != -1) {
				byte[] cbuf = desCipher.doFinal(buffer, 0, bytes_leidos);
				os.write(cbuf);
				bytes_leidos = is.read(buffer);
			}

			os.close();

			System.out.println("Obteniendo factoría de claves con cifrado RSA");
			KeyFactory keyfac = KeyFactory.getInstance("RSA");
			System.out.println("Generando keyspec");
			RSAPublicKeySpec publicKeySpec = keyfac.getKeySpec(keypair.getPublic(), RSAPublicKeySpec.class);

			System.out.println("Salvando la clave en un fichero");

			FileOutputStream cos = new FileOutputStream(".\\nueva\\clave_publica");
			PrintWriter pw = new PrintWriter(cos);

			pw.println(publicKeySpec.getModulus());
			pw.println(publicKeySpec.getPublicExponent());

			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}