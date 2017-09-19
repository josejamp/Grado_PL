package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%class AnalizadorLexicoTiny
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letraMinus = [a-z]
letraMayus = [A-Z]
letra  = ({letraMinus}|{letraMayus})
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
exponencial = [e E]
parteDecimal = ((\.){digito}*{digitoPositivo})
parteExponencial = ({exponencial}(((\-?)({digitoPositivo}{digito}*|0))))
espacio = [ \t\r\b\n]
entero = (({digitoPositivo}{digito}*)|0)
numReal = ({entero}({parteDecimal}|{parteExponencial}|({parteDecimal}{parteExponencial})))
separadorSecciones = #
separadorInstrucciones = ;
tipo = tipo
int = int
real = real
corcheteApertura = \[
corcheteCierre = \]
registroAp = rec
registroCierre = endrec
puntero = pointer
objetoAp = object
objetoCierre = endobject
herencia = extends
end = end
funcion = fun
metodo = method
devuelve = returns
coma = \,
referencia = &
parentesisAp = \(
parentesisCierre = \)
this = this
super = super
punto = \.
acento = ['^']
menor = <
mayor = >
menorIgual = <\=
mayorIgual = >\=
igual = \=\=
distinto = !\=
or = \|\|
and = &&
not = !
suma = \+
resta = \-
multiplicacion = \*
division = /
modulo = \%
asignacion = \=
castInt = \(int\)
castReal = \(real\)
return = return
null = null
entrada = in
salida = out
reserva = alloc
libera = free
if = if
else = else
elsif = elsif
then = then
endif = endif
while = while
do = do
endwhile = endwhile
identificador = ({letra}|_)({letra}|{digito}|_)*
%%
{espacio}                             {}
{entero}                              {return ops.unidadEntero();} 
{numReal}                             {return ops.unidadNumReal();} 
{separadorSecciones}                  {return ops.unidadSecciones();}
{separadorInstrucciones}              {return ops.unidadInstrucciones();}
{tipo}                                {return ops.unidadTipo();}
{int}                                 {return ops.unidadInt();}
{real}                                {return ops.unidadReal();}
{corcheteApertura}                    {return ops.unidadCAp();}
{corcheteCierre}                      {return ops.unidadCCierre();}
{registroAp}                          {return ops.unidadRegAp();}
{registroCierre}                      {return ops.unidadRegCierre();}
{puntero}                             {return ops.unidadPuntero();}
{objetoAp}                            {return ops.unidadObjAp();} 
{objetoCierre}                        {return ops.unidadObjCierre();} 
{herencia}                            {return ops.unidadHerencia();}
{end}                                 {return ops.unidadEnd();}
{funcion}                             {return ops.unidadFun();}
{metodo}                              {return ops.unidadMetodo();}
{devuelve}                            {return ops.unidadDev();}
{coma}                                {return ops.unidadComa();}
{referencia}                          {return ops.unidadRef();}
{parentesisAp}                        {return ops.unidadPAp();}
{parentesisCierre}                    {return ops.unidadPCierre();}
{this}                                {return ops.unidadThis();}
{super}                               {return ops.unidadSuper();}
{punto}                               {return ops.unidadPunto();} 
{acento}                              {return ops.unidadAcento();} 
{menor}                               {return ops.unidadMenor();}
{mayor}                               {return ops.unidadMayor();}
{menorIgual}                          {return ops.unidadMenorIg();}
{mayorIgual}                          {return ops.unidadMayorIg();}
{igual}                               {return ops.unidadIgual();}
{distinto}                            {return ops.unidadDistinto();}
{or}                                  {return ops.unidadOR();}
{and}                                 {return ops.unidadAND();}
{not}                                 {return ops.unidadNOT();}
{suma}                                {return ops.unidadRegSuma();}
{resta}                               {return ops.unidadResta();}
{multiplicacion}                      {return ops.unidadMult();} 
{division}                            {return ops.unidadDiv();} 
{modulo}                              {return ops.unidadMod();}
{asignacion}                          {return ops.unidadAsig();}
{castInt}                             {return ops.unidadCastInt();}
{castReal}                            {return ops.unidadCastReal();}
{return}                              {return ops.unidadReturn();}
{null}                                {return ops.unidadNull();}
{entrada}                             {return ops.unidadIn();}
{salida}                              {return ops.unidadOut();}
{reserva}                             {return ops.unidadReserva();}
{libera}                              {return ops.unidadLibera();}
{if}                                  {return ops.unidadIf();}
{else}                                {return ops.unidadElse();} 
{elsif}                               {return ops.unidadElsif();} 
{then}                                {return ops.unidadThen();}
{endif}                               {return ops.unidadEndIf();}
{while}                               {return ops.unidadWhile();} 
{do}                                  {return ops.unidadDo();} 
{endwhile}                            {return ops.unidadEndWhile();}
{identificador}                       {return ops.unidadId();}
[^]                                   {errores.errorLexico(fila(),lexema());}  