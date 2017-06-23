package univel.br;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Exemplo {
	
	
	public static void main(String[] args) throws Exception{
		
		//BUFFER garante que o fluxo seja continuo
		
		URL url = new URL("http://www.master10.com.py/lista-txt/donwload");
		URLConnection urlCon = url.openConnection();//aberta concxao com o site
		
		try(InputStream is = urlCon.getInputStream();// desenha o caminho do site aqui o aqui
				InputStreamReader isr = new InputStreamReader(is);//le a vazao
				BufferedReader in = new BufferedReader(isr)){// vai ler uma linha por vez
				
				String linha;
				while ((linha = in.readLine()) != null){	// se a linha for diferenrte de nulo ok
					System.out.println(linha);
				}
		}
	}

}
