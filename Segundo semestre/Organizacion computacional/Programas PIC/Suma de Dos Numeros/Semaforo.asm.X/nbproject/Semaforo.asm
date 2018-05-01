#INCLUDE <P16F628A.INC>
__CONFIG _BOREN_ON & _CP_OFF & _PWRTE_ON & _WDT_OFF & _LVP_OFF & _MCLRE_OFF & _XT_OSC

#DEFINE	BANK0	BCF STATUS,RP0	
#DEFINE	BANK1	BSF STATUS,RP0

;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
;*                         VARIABLES                               *
;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

	CBLOCK	0x20	;INICIAL DE MEMORIA DE USUARIO
		D1 			; FUNCION DELAY
		D2 			; FUNCION DELAY
		D3 			; FUNCION DELAY
	ENDC			;FIN MEMORIA
	
;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
;*                       RESET		                           *
;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

	ORG	0x00			;INICIO DE PROCESAMIENTO
	GOTO	INICIO

;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
;*	            	 RUTINAS Y SUBRUTINAS                      *
;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

;FUNCION DE DELAY DE 15 SEGUNDOS
DELAY10S
	MOVLW	0x5A
	MOVWF	D1
	MOVLW	0xCD
	MOVWF	D2
	MOVLW	0x16
	MOVWF	D3
DELAY10S_0
	DECFSZ	D1, f
	GOTO	$+2
	DECFSZ	D2, f
	GOTO	$+2
	DECFSZ	D3, f
	GOTO	DELAY10S_0
	NOP		
RETURN

;FUNCION DE DELAY DE 5 SEGUNDOS
DELAY5S	
	MOVLW	0x2C
	MOVWF	D1
	MOVLW	0xE7
	MOVWF	D2
	MOVLW	0x0B
	MOVWF	D3
DELAY5S_0
	DECFSZ	D1, f
	GOTO	$+2
	DECFSZ	D2, f
	GOTO	$+2
	DECFSZ	D3, f
	GOTO	DELAY5S_0			
	GOTO	$+1
	NOP			
RETURN

;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
;*                     INICIO DE PROGRAMA                          *
;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	
INICIO
	BANK1
	MOVLW	B'00000000'
	MOVWF	TRISA		;ENTRADAS Y SALIDAS PORTA
	MOVLW	B'00000000'
	MOVWF	TRISB		;ENTRADAS Y SALIDAS PORTB
	MOVLW	B'10000100'
	MOVWF	OPTION_REG
	MOVLW	B'00000000'
	MOVWF	INTCON		
	BANK0
	MOVLW	B'00000111'
	MOVWF	CMCON

;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
;*                     RUTINA PRINCIPAL                            *
;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

MAIN
	MOVLW	B'10000100'		;SEMAFORO 1 VERDE, SEMAFORO 2 ROJO
	MOVWF	PORTB
	CALL DELAY10S
	
	MOVLW	B'10000010'		;SEMAFORO 1 AMARILLO,  SEMAFORO 2 ROJO
	MOVWF	PORTB
	CALL DELAY5S
	
	MOVLW	B'00100001'		;SEMAFORO 1 ROJO, SEMAFORO 2 VERDE
	MOVWF	PORTB
	CALL DELAY10S
	
	MOVLW	B'01000001'		;SEMAFORO 1 ROJO, SEMAFORO 2 AMARILLO
	MOVWF	PORTB
	CALL DELAY5S
GOTO MAIN

;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
;*                       FIN DE PROGRAMA                           *
;* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

	END


