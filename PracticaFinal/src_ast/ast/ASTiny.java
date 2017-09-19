package ast;

import ast.declaraciones.Cabecera;
import ast.declaraciones.CabeceraComp;
import ast.declaraciones.CabeceraSimple;
import ast.declaraciones.CampI;
import ast.declaraciones.CampICampo;
import ast.declaraciones.CampIMetodo;
import ast.declaraciones.Campo;
import ast.declaraciones.CampoConst;
import ast.declaraciones.CampoObj;
import ast.declaraciones.CampoObjeto;
import ast.declaraciones.CampoObjetoSimple;
import ast.declaraciones.CampoObjetoVacio;
import ast.declaraciones.Campos;
import ast.declaraciones.CamposComp;
import ast.declaraciones.CamposSimple;
import ast.declaraciones.Dec;
import ast.declaraciones.DecF;
import ast.declaraciones.DecFM;
import ast.declaraciones.DecFMFun;
import ast.declaraciones.DecFMMet;
import ast.declaraciones.DecFuncion;
import ast.declaraciones.DecFuncionMetodo;
import ast.declaraciones.DecM;
import ast.declaraciones.DecMetodo;
import ast.declaraciones.DecT;
import ast.declaraciones.DecTipo;
import ast.declaraciones.DecV;
import ast.declaraciones.DecVar;
import ast.declaraciones.DecVariable;
import ast.declaraciones.DeclaracionArray;
import ast.declaraciones.DeclaracionInt;
import ast.declaraciones.DeclaracionObjeto;
import ast.declaraciones.DeclaracionObjetoSimple;
import ast.declaraciones.DeclaracionPuntero;
import ast.declaraciones.DeclaracionReal;
import ast.declaraciones.DeclaracionRegistro;
import ast.declaraciones.Declaraciones;
import ast.declaraciones.DeclaracionesSimple;
import ast.declaraciones.DeclaracionesVacia;
import ast.declaraciones.Decs;
import ast.declaraciones.DescrT;
import ast.declaraciones.DescripcionTipo;
import ast.declaraciones.Par;
import ast.declaraciones.Parametro;
import ast.declaraciones.ParametroRef;
import ast.declaraciones.Parametros;
import ast.declaraciones.ParametrosSimple;
import ast.declaraciones.ParametrosVacio;
import ast.declaraciones.Params;
import ast.designadores.Designador;
import ast.designadores.DesignadorArray;
import ast.designadores.DesignadorID;
import ast.designadores.DesignadorPuntero;
import ast.designadores.DesignadorRegistro;
import ast.designadores.DesignadorSuper;
import ast.designadores.DesignadorThis;
import ast.expresiones.And;
import ast.expresiones.CastInt;
import ast.expresiones.CastReal;
import ast.expresiones.DesignadorE;
import ast.expresiones.Distinto;
import ast.expresiones.Div;
import ast.expresiones.E;
import ast.expresiones.Exp;
import ast.expresiones.ExpComp;
import ast.expresiones.ExpEntero;
import ast.expresiones.ExpID;
import ast.expresiones.ExpReal;
import ast.expresiones.ExpSimple;
import ast.expresiones.ExpVacia;
import ast.expresiones.ExpresionFuncion;
import ast.expresiones.ExpresionMetodo;
import ast.expresiones.Igual;
import ast.expresiones.InvF;
import ast.expresiones.InvM;
import ast.expresiones.InvocacionF;
import ast.expresiones.InvocacionM;
import ast.expresiones.Mayor;
import ast.expresiones.MayorIgual;
import ast.expresiones.Menor;
import ast.expresiones.MenorIgual;
import ast.expresiones.Menos;
import ast.expresiones.Mod;
import ast.expresiones.Mul;
import ast.expresiones.Not;
import ast.expresiones.Null;
import ast.expresiones.Or;
import ast.expresiones.Resta;
import ast.expresiones.Suma;
import ast.expresiones.TipoOp;
import ast.instrucciones.Asignacion;
import ast.instrucciones.Caso;
import ast.instrucciones.CasoSimple;
import ast.instrucciones.CasosIf;
import ast.instrucciones.CasosIfComp;
import ast.instrucciones.CasosIfSimple;
import ast.instrucciones.Escritura;
import ast.instrucciones.IfElse;
import ast.instrucciones.IfSimple;
import ast.instrucciones.Inst;
import ast.instrucciones.InstFuncion;
import ast.instrucciones.InstMetodo;
import ast.instrucciones.InstReturn;
import ast.instrucciones.InstWhile;
import ast.instrucciones.Instruccion;
import ast.instrucciones.Instrucciones;
import ast.instrucciones.Insts;
import ast.instrucciones.Lectura;
import ast.instrucciones.LiberarMemoria;
import ast.instrucciones.ReservarMemoria;

public class ASTiny {

	public Prog programa(Decs decs, Insts insts, int row){ return new Programa(decs, insts, row); }
	public Decs declaraciones(Decs decs, Dec dec, int row){ return new Declaraciones(decs, dec, row); }
	public Decs declaracionesSimple(Dec dec, int row){ return new DeclaracionesSimple(dec, row); }
	public Decs declaracionesVacia(int row){ return new DeclaracionesVacia(row); }
	public Dec decV(DecVar decVar, int row){ return new DecV(decVar, row); }
	public Dec decT(DescrT descrT, int row){ return new DecT(descrT, row); }
	public Dec decFuncionMetodo(DecFM decFM, int row){ return new DecFuncionMetodo(decFM, row); }
	public DecVar decVariable(DescrT descrT, String id, int row){ return new DecVariable(descrT, id, row); }
	public DescrT decTipo(DescrT descrT, String id, int row){ return new DecTipo(descrT, id, row); }
	public DescrT declaracionInt(int row){ return new DeclaracionInt(row); }
	public DescrT declaracionReal(int row){ return new DeclaracionReal(row); }
	public DescrT declaracionArray(DescrT descrT, String num, int row){ return new DeclaracionArray(descrT, num, row); }
	public DescrT declaracionRegistro(Campos campos, int row){ return new DeclaracionRegistro(campos, row); }
	public DescrT declaracionPuntero(DescrT descrT, int row){ return new DeclaracionPuntero(descrT, row); }
	public DescrT declaracionObjeto(CampoObj campoObj, String id, int row){ return new DeclaracionObjeto(campoObj, id, row); }
	public DescrT declaracionObjetoSimple(CampoObj campoObj, int row){ return new DeclaracionObjetoSimple(campoObj, row); }
	public DescrT descripcionTipo(String id, int row){ return new DescripcionTipo(id, row); }
	public Campos camposComp(Campos campos, Campo campo, int row){ return new CamposComp(campos, campo, row); }
	public Campos camposSimple(Campo campo, int row){ return new CamposSimple(campo, row); }
	public Campo campoConst(DescrT descrT, String id, int row){ return new CampoConst(descrT, id, row); }
	public CampoObj campoObjeto(CampoObj campoObj, CampI campI, int row){ return new CampoObjeto(campoObj, campI, row); }
	public CampoObj campoObjetoSimple(CampI campI, int row){ return new CampoObjetoSimple(campI, row); }
	public CampoObj campoObjetoVacio(int row){ return new CampoObjetoVacio(row); }
	public CampI campICampo(Campo campo, int row){ return new CampICampo(campo, row); }
	public CampI campIMetodo(DecM decM, int row){ return new CampIMetodo(decM, row); }
	public DecFM decFMMet(DecM decM, int row){ return new DecFMMet(decM, row); }
	public DecFM decFMFun(DecF decF, int row){ return new DecFMFun(decF, row); }
	public DecF decFuncion(Cabecera cabecera, Prog prog, String id, int row){ return new DecFuncion(cabecera, prog, id, row); }
	public DecM decMetodo(Cabecera cabecera, Prog prog, String id, int row){ return new DecMetodo(cabecera, prog, id, row); }
	public Cabecera cabeceraComp(Params params, String id, DescrT descrT, int row){ return new CabeceraComp(params, id, descrT, row); }
	public Cabecera cabeceraSimple(Params params, String id, int row){ return new CabeceraSimple(params, id, row); }
	public Params parametros(Params params, Par par, int row){ return new Parametros(params, par, row); }
	public Params parametrosSimple(Par par, int row){ return new ParametrosSimple(par, row); }
	public Params parametrosVacio(int row){ return new ParametrosVacio(row); }
	public Par parametro(DescrT descrT, String id, int row){ return new Parametro(descrT, id, row); }
	public Par parametroRef(DescrT descrT, String id, int row){ return new ParametroRef(descrT, id, row); }
	public Designador designadorArray(Designador des, E e, int row){ return new DesignadorArray(des, e, row); }
	public Designador designadorRegistro(Designador des, String id, int row){ return new DesignadorRegistro(des, id, row); }
	public Designador designadorPuntero(Designador des, int row){ return new DesignadorPuntero(des, row); }
	public Designador designadorID(String id, int row){ return new DesignadorID(id, row); }
	public Designador designadorThis(int row){ return new DesignadorThis(row); }
	public Designador designadorSuper(int row){ return new DesignadorSuper(row); }
	public E menor(E op1, E op2, int row){ return new Menor(op1, op2, row); }
	public E mayor(E op1, E op2, int row){ return new Mayor(op1, op2, row); }
	public E menorIgual(E op1, E op2, int row){ return new MenorIgual(op1, op2, row); }
	public E mayorIgual(E op1, E op2, int row){ return new MayorIgual(op1, op2, row); }
	public E igual(E op1, E op2, int row){ return new Igual(op1, op2, row); }
	public E distinto(E op1, E op2, int row){ return new Distinto(op1, op2, row); }
	public E or(E op1, E op2, int row){ return new Or(op1, op2, row); }
	public E suma(E op1, E op2, int row){ return new Suma(op1, op2, row); }
	public E resta(E op1, E op2, int row){ return new Resta(op1, op2, row); }
	public E mul(E op1, E op2, int row){ return new Mul(op1, op2, row); }
	public E div(E op1, E op2, int row){ return new Div(op1, op2, row); }
	public E mod(E op1, E op2, int row){ return new Mod(op1, op2, row); }
	public E and(E op1, E op2, int row){ return new And(op1, op2, row); }
	public E not(E op, int row){ return new Not(op, row); }
	public E menos(E op, int row){ return new Menos(op, row); }
	public E castInt(E op, int row){ return new CastInt(op, row); }
	public E castReal(E op, int row){ return new CastReal(op, row); }
	public E nullM(int row){ return new Null(row); }
	public E designadorE(Designador des, int row){ return new DesignadorE(des, row); }
	public E expresionFuncion(InvF invF, int row){ return new ExpresionFuncion(invF, row); }
	public E expresionMetodo(InvM invM, int row){ return new ExpresionMetodo(invM, row); }
	public E entero(String entero, int row){ return new ExpEntero(entero, row); }
	public E real(String real, int row){ return new ExpReal(real, row); }
	public E id(String id, int row){ return new ExpID(id, row); }
	public Exp expComp(Exp exp, E e, int row){ return new ExpComp(exp, e, row); }
	public Exp expSimple(E e, int row){ return new ExpSimple(e, row); }
	public Exp expVacia(int row){ return new ExpVacia(row); }
	public InvF invocacionF(String id, Exp exp, int row){ return new InvocacionF(id, exp, row); }
	public InvM invocacionM(Designador des, String id, Exp exp, int row){ return new InvocacionM(des, id, exp, row); }
	public Insts instrucciones(Insts insts, Inst inst, int row){ return new Instrucciones(insts, inst, row); }
	public Insts instruccion(Inst inst, int row){ return new Instruccion(inst, row); }
	public Inst asignacion(Designador des, E e, int row){ return new Asignacion(des,e, row); }
	public Inst lectura(Designador des, int row){ return new Lectura(des, row); }
	public Inst escritura(E e, int row){ return new Escritura(e, row); }
	public Inst liberarMemoria(Designador des, int row){ return new LiberarMemoria(des, row); }
	public Inst reservarMemoria(Designador des, int row){ return new ReservarMemoria(des, row); }
	public Inst ifSimple(CasosIf casosIf, int row){ return new IfSimple(casosIf, row); }
	public Inst ifElse(CasosIf casosIf, Insts insts, int row){ return new IfElse(casosIf, insts, row); }
	public Inst instWhile(E e, Insts insts, int row){ return new InstWhile(e, insts, row); }
	public Inst instReturn(E e, int row){ return new InstReturn(e, row); }
	public Inst instFuncion(InvF invF, int row){ return new InstFuncion(invF, row); }
	public Inst instMetodo(InvM invM, int row){ return new InstMetodo(invM, row); }
	public CasosIf casosIfComp(CasosIf casosIf, Caso caso, int row){ return new CasosIfComp(casosIf, caso, row); }
	public CasosIf casosIfSimple(Caso caso, int row){ return new CasosIfSimple(caso, row); }
	public Caso casoSimple(E e, Insts insts, int row){ return new CasoSimple(e, insts, row); }
	
	public E mkExp(E op1, E op2, TipoOp op, int row){
		switch(op){
		case MENOR: return new Menor(op1, op2, row);
		case MAYOR: return new Mayor(op1, op2, row);
		case MAYOR_IGUAL: return new MayorIgual(op1, op2, row);
		case MENOR_IGUAL: return new MenorIgual(op1, op2, row);
		case IGUAL: return new Igual(op1, op2, row);
		case DISTINTO: return new Distinto(op1, op2, row);
		case OR: return new Or(op1, op2, row);
		case SUMA: return new Suma(op1, op2, row);
		case RESTA: return new Resta(op1, op2, row);
		case MUL: return new Mul(op1, op2, row);
		case DIV: return new Div(op1, op2, row);
		case MOD: return new Mod(op1, op2, row);
		case AND: return new And(op1, op2, row);
		case NOT: return new Not(op1, row);
		case MENOS: return new Menos(op1, row);
		case CAST_INT: return new CastInt(op1, row);
		case CAST_REAL: return new CastReal(op1, row);
		}
		System.out.println("Error: " + op.toString());
		return null;
	}
}
