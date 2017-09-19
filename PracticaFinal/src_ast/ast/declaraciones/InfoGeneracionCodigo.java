package ast.declaraciones;

public class InfoGeneracionCodigo {

	
	/* Informacion para variables y parametros */
	
	private Integer nivel;
	private Integer dir;
	public Integer tam;
	
	public InfoGeneracionCodigo(){}
	
	public InfoGeneracionCodigo(Integer nivel, Integer dir) {
		this.nivel = nivel;
		this.dir = dir;
	}
	public InfoGeneracionCodigo(Integer nivel, Integer dir, Integer tam) {
		this.nivel = nivel;
		this.dir = dir;
		this.tam = tam;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Integer getDir() {
		return dir;
	}
	public void setDir(Integer dir) {
		this.dir = dir;
	}
	public Integer getTam() {
		return tam;
	}
	public void setTam(Integer tam) {
		this.tam = tam;
	}

	@Override
	public String toString() {
		return "InfoGeneracionCodigo [nivel=" + nivel + ", dir=" + dir + "]";
	}
	
	
	
	
	/* Informacion para funciones */
	
	private Integer dirPrologoFun;
	
	public InfoGeneracionCodigo(Integer dirPrologoFun) {
		this.dirPrologoFun = dirPrologoFun;
	}
	public Integer getDirPrologoFun() {
		return dirPrologoFun;
	}
	public void setDirPrologoFun(Integer dirPrologoFun) {
		this.dirPrologoFun = dirPrologoFun;
	}
	
}
