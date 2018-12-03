package br.senai.sp.cfp127.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;

public class CompromissoDao {
	
	private Compromisso compromisso;
	private PreparedStatement stm;
	private ResultSet rs;

	public ArrayList<Compromisso> getCompromissos(int codUsuario, int status) {
		ArrayList<Compromisso> compromissos = new ArrayList<>();

		String sql = "SELECT * FROM tbl_compromisso WHERE cod_usuario =" +codUsuario+" AND status="+status;
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setStatus(rs.getInt("status"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
	
				compromissos.add(this.compromisso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexao.fechasrConexao();
		}

		return compromissos;
	}
	
	public ArrayList<Compromisso> getCompromissos3(int codUsuario) {
		ArrayList<Compromisso> compromissos = new ArrayList<>();

		String sql = "SELECT * FROM tbl_compromisso WHERE cod_usuario =" +codUsuario+" AND status= 0 ORDER BY data LIMIT 3";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setStatus(rs.getInt("status"));
				this.compromisso.setDescricao(rs.getString("descricao"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
	
				compromissos.add(this.compromisso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexao.fechasrConexao();
		}

		return compromissos;
	}
	
	
	
	public Compromisso getCompromisso(int cod_compromisso) {
		Compromisso c = new Compromisso();

		String sql = "SELECT * FROM tbl_compromisso "+"WHERE cod_compromisso ="+cod_compromisso;
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			rs = stm.executeQuery();

				if(rs.next()) {
				c.setCod_compromisso(rs.getInt("cod_compromisso"));
				c.setTitulo(rs.getString("titulo"));
				c.setData(rs.getString("data"));
				c.setDescricao(rs.getString("descricao"));
				c.setHoraInicio(rs.getString("horaInicio"));
				c.setHoraFim(rs.getString("horaFim"));
				c.setStatus(rs.getInt("status"));
				c.setPrioridade(rs.getInt("prioridade"));
	
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexao.fechasrConexao();
		}
		return c;

		
	}
	
	
	
	public boolean atulizar(Compromisso c) {
		String sql="UPDATE tbl_compromisso SET titulo=?, data=?, horaInicio=?, descricao=?, prioridade=?, horaFim=? WHERE cod_compromisso = ?";
		
		try{
			stm=Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, c.getTitulo());
			stm.setString(2, c.getData());
			stm.setString(3, c.getHoraInicio());
			stm.setString(4, c.getDescricao());
			stm.setInt(5, c.getPrioridade());
			stm.setString(6, c.getHoraFim());
			stm.setInt(7, c.getCod_compromisso());
			stm.execute();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Conexao.fechasrConexao();
		}
		
		
	}
	
	
	
	public boolean atulizarStatus(int cod, int status) {
		String sql="UPDATE tbl_compromisso SET status=? WHERE cod_compromisso = ?";
		
		try{
			stm=Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1,status);
			stm.setInt(2, cod);
		
			stm.execute();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Conexao.fechasrConexao();
		}
		
		
	}
	
	
	
	
	
	
//	public ArrayList<Compromisso> getCompromissosFiltro(String sql) {
//		ArrayList<Compromisso> compromissos = new ArrayList<>();
//
//		try {
//			stm = Conexao.getConexao().prepareStatement(sql);
//			rs = stm.executeQuery();
//
//			while (rs.next()) {
//				this.compromisso = new Compromisso();
//				this.compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
//				this.compromisso.setTitulo(rs.getString("titulo"));
//				this.compromisso.setData(rs.getString("data"));
//				this.compromisso.setStatus(rs.getInt("status"));
//				this.compromisso.setPrioridade(rs.getInt("prioridade"));
//	
//				compromissos.add(this.compromisso);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return compromissos;
//	}
	
	public boolean gravar (Compromisso c) {
		String sql="INSERT INTO tbl_compromisso "
				+ "(cod_usuario, titulo, data, horaInicio, horaFim, descricao, prioridade, status)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

				try {
					
					stm = Conexao.getConexao().prepareStatement(sql);
					stm.setInt(1, c.getUsuario().getCod());
					stm.setString(2, c.getTitulo());
					stm.setString(3, c.getData());;
					stm.setString(4, c.getHoraInicio());
					stm.setString(5, c.getHoraFim());
					stm.setString(6, c.getDescricao());
					stm.setInt(7, c.getPrioridade());
					stm.setInt(8, 0);
					stm.execute();
						return true;
									
				} catch (SQLException e) {
					System.out.println("Erro no gravar compromisso.");
					e.printStackTrace();
					return false;
				}finally {
					Conexao.fechasrConexao();
				}
	
		
	}
	

}
