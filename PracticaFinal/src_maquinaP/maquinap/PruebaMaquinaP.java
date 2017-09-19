package maquinap;

import maquinap.instrucciones.*;

public class PruebaMaquinaP {
   public void prueba() {
     Instruccion[] programa = {
         new IrA(30),                    //0 
         new Apila(new ValorEntero(0)),  //1
         new Apila(new ValorEntero(18)),  //2
         new DesapilaInd(),              //3
         new Apila(new ValorEntero(1)),  //4
         new Apila(new ValorEntero(9)), //5
         new DesapilaInd(),              //6
         new Apila(new ValorEntero(0)),  //7
         new ApilaInd(),                 //8
         new Apila(new ValorEntero(1)),  //9
         new ApilaInd(),                 //10
         new NEq(),                      //11
         new IrF(29),                    //12
         new Apila(new ValorEntero(0)),  //13
         new ApilaInd(),                 //14
         new Apila(new ValorEntero(1)),  //15
         new ApilaInd(),                 //16
         new Mayor(),                    //17
         new IrF(24),                    //18
         new ApilaDir(0),                //19
         new ApilaDir(1),                //20
         new Resta(),                    //21
         new DesapilaDir(0),             //22
         new IrA(28),                    //23
         new ApilaDir(1),                //24
         new ApilaDir(0),                //25
         new Resta(),                    //26
         new DesapilaDir(1),             //27
         new IrA(7),                     //28
         new IrInd(),                    //29
         new Apila(new ValorEntero(32)), //30
         new IrA(1),                     //31
         new ApilaDir(0),                //32 
         new Escribe()};                 //33 
     MaquinaP maquina = new MaquinaP(5,10,programa);
     maquina.ejecuta();
   }  
}
