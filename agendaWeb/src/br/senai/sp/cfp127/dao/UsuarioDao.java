package br.senai.sp.cfp127.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

public class UsuarioDao {
	
	private Usuario usuario;
	private PreparedStatement stm;
	private ResultSet rs; //RESULTADO DA CONSULTA
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	// *** M�TODO PARA GRAVAR O USU�RIO NO BANCO *** //
	public boolean gravar() {
		
		String sql = "INSERT INTO tbl_usuario(nome, email, senha, sexo, dtNascimento) VALUES (?, ?, ?, ?,?)";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getSexo().substring(0, 1)); //VAI NO INDICE 0 E EXTRAI 1 CARACTER
			stm.setString(5, usuario.getDtNascimento());
			
			stm.execute(); //COMANDO PARA EXECUTAR
		
			
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Conexao.fechasrConexao();
		}
		

	}
public boolean atualizar() {
		
		String sql = "UPDATE  tbl_usuario SET nome=?, email=?, senha=?, sexo=?, dtNascimento=? WHERE cod=?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getSexo().substring(0, 1)); //VAI NO INDICE 0 E EXTRAI 1 CARACTER
			stm.setString(5, usuario.getDtNascimento());
			stm.setInt(6, usuario.getCod());
			
			stm.execute(); //COMANDO PARA EXECUTAR
			
			
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERRO NO ATUALIZAR");
			return false;
		}finally {
			Conexao.fechasrConexao();
		}
		

	}
	
	public Usuario autenticar(String email, String senha){
		
		this.usuario = new Usuario();
		String sql = "SELECT * FROM tbl_usuario WHERE senha= ? AND email=?";
		
		try{
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, senha);
			stm.setString(2, email);
			
			rs = stm.executeQuery(); // COMANDO DE CONSULTA executeQuery;
			
			
			if(rs.next()) {
				this.usuario.setCod(rs.getInt("cod"));
				this.usuario.setNome(rs.getString("nome"));
				this.usuario.setEmail(rs.getString("email"));
				this.usuario.setSexo(rs.getString("sexo"));;
				this.usuario.setDtNascimento(rs.getString("dtNascimento"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexao.fechasrConexao();
		}
		
		return this.usuario;
	
	}
	
	
}