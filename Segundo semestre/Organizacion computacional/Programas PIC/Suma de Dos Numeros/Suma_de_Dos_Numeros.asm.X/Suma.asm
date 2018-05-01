    LIST P=16F84
    INCLUDE <P16F84.INC>
    __CONFIG _RC_OSC & _CP_OFF & _WDT_OFF & _PWRTE_ON
    
    
    OPERANDO1 EQU h'0c'
    OPERANDO2 EQU h'0d'
    RESULTADO EQU h'0e'
 
 org 0 
 
 movlw d'05'
 movwf OPERANDO1
 movlw d'02'
 movwf OPERANDO2
 movfw OPERANDO1
 addwf OPERANDO2,0
 movwf RESULTADO
 
 end