

import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class TesteConexao {
	
	public static void main(String[] args){
		
		testaConexao();
		System.out.println("Aplicação Conectado com sucesso no Banco!!!");
		
	}
	
	public static void testaConexao(){
		ConexaoFactory.getConxao();
	}

}
