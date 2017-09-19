package alex;

import constructorast.ClaseLexica;

public class ALexOperations {
	
	private AnalizadorLexicoTiny analizador;
	  public ALexOperations(AnalizadorLexicoTiny analizador) {
	   this.analizador = analizador;   
	  }
	  public UnidadLexica unidadSecciones() {
	     return new UnidadLexica(analizador.fila(), ClaseLexica.SEPARADOR_SECCION, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadInstrucciones() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.SEPARADOR_INST, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadTipo() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.TIPO, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadInt() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.INT, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadReal() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.REAL, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadCAp() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.COR_AP, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadCCierre() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.COR_CIERRE, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadRegAp() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.REC, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadRegCierre() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ENDREC, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadPuntero() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.POINTER, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadObjAp() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.OBJECT, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadObjCierre() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ENDOBJECT, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadHerencia() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.EXTENDS, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadEnd() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.END, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadFun() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.FUN, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadMetodo() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.METHOD, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadDev() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.RETURNS, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadComa() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.COMA, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadRef() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.REFERENCIA, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadPAp() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.PAR_AP, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadPCierre() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.PAR_CIERRE, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadThis() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.THIS, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadSuper() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.SUPER, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadPunto() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.PUNTO, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadAcento() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ACENTO, analizador.lexema()); 
	  }	  
	  
	  public UnidadLexica unidadMenor() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.MENOR, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadMayor() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.MAYOR, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadMenorIg() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.MENOR_IGUAL, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadMayorIg() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.MAYOR_IGUAL, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadIgual() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.IGUAL, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadDistinto() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.DISTINTO, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadOR() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.OR, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadAND() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.AND, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadNOT() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.NOT, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadRegSuma() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.SUMA, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadResta() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.RESTA, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadMult() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.MULT, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadDiv() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.DIV, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadMod() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.MODULO, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadAsig() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ASIGNACION, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadCastInt() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.CAST_INT, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadCastReal() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.CAST_REAL, analizador.lexema()); 
	  }	  
	  
	  public UnidadLexica unidadReturn() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.RETURN, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadNull() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.NULL, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadIn() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.IN, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadOut() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.OUT, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadReserva() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ALLOC, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadLibera() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.FREE, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadIf() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.IF, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadElse() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ELSE, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadElsif() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ELSIF, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadThen() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.THEN, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadEndIf() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ENDIF, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadWhile() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.WHILE, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadDo() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.DO, analizador.lexema()); 
	  }
	  	  
	  public UnidadLexica unidadEndWhile() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ENDWHILE, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadId() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ID, analizador.lexema()); 
	  } 
	  
	  public UnidadLexica unidadEntero() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.ENTERO, analizador.lexema()); 
	  }
	  
	  public UnidadLexica unidadNumReal() {
		     return new UnidadLexica(analizador.fila(), ClaseLexica.NUM_REAL, analizador.lexema()); 
	  }	  
	 
	  public UnidadLexica unidadEof() {
	     return new UnidadLexica(analizador.fila(),ClaseLexica.EOF, analizador.lexema()); 
	  }
	  
	  public void error() {
	    System.err.println("***"+analizador.fila()+" Caracter inexperado: "+analizador.lexema());
	  }

}
