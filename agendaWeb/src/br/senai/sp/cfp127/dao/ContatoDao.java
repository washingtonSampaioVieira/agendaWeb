package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.BlockElement;

import br.senai.sp.cfp127.model.Contato;

public class ContatoDao {
	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<Contato> getContatos(int codUsuario){
		ArrayList<Contato> contatos = new ArrayList<>();
		
		String sql= "SELECT * FROM tbl_contato "
				+ "WHERE cod_usuario = ? ORDER BY nome";
		try {
			stm=Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			rs = stm.executeQuery();
			
			while(rs.next()) {
				this.contato = new Contato();
				this.contato.setCodContato(rs.getInt("cod_contato"));
				this.contato.setNome(rs.getString("nome"));
				this.contato.setEmail(rs.getNString("email"));
				this.contato.setTelefone(rs.getString("telefone"));
				this.contato.setEndereco(rs.getString("endereco"));
				contatos.add(this.contato);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return contatos ;
	}
	public boolean gravar (Contato c) {
		String sql=" INSERT INTO tbl_contato (cod_usuario, nome, telefone, email, endereco) VALUES (?,?,?,?,?)";
		try {
			stm= Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, c.getUsuario().getCod());
			stm.setString(2, c.getNome());
			stm.setString(3, c.getTelefone());
			stm.setString(4, c.getEmail());
			stm.setString(5, c.getEndereco() );
			
			stm.execute();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean excluir (int cod_contato) {
		String sql= "DELETE FROM tbl_contato WHERE cod_contato="+cod_contato;
		
		try{
		stm = Conexao.getConexao().prepareStatement(sql);
		stm.execute();
		return true;	
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean atulizar(Contato c) {
		String sql="UPDATE tbl_contato SET nome=?, telefone=?, email=?, endereco=? WHERE cod_contato = ?";
		
		try{
			stm=Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, c.getNome());
			stm.setString(2, c.getTelefone());
			stm.setString(3, c.getEmail());
			stm.setString(4, c.getEndereco());
			stm.setInt(5, c.getCodContato());
			stm.execute();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	public Contato getContato(int codContato){
			
		Contato c = new Contato();
		String sql= "SELECT * FROM tbl_contato "
				+ "WHERE cod_contato = ?";
		try {
			stm=Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codContato);
			rs = stm.executeQuery();
			if(rs.next()) {
				
				c.setCodContato(rs.getInt("cod_contato"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
			}

			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return c ;
	}
}
