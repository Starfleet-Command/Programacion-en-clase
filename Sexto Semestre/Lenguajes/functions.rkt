#|
    DEFINE ALL THE FUNCTIONS
|#

#lang racket

(define (get-pi) (*(atan 1) 4))
(get-pi)
(current-directory)
(string->path "C:\\Downloads")

(define (FtoC temp)
(*(- temp 32) 5/9)
)

(define (CtoF temp)
(+(* temp 9/5) 32)
)

(FtoC 45)
(CtoF 65/9)

(define (get-s a b c)
(/ (+ a b c) 2) 

)

(define (area a b c)
    (sqrt(* 
        (get-s a b c) 
        (- (get-s a b c) a) 
        (- (get-s a b c) b) 
        (- (get-s a b c) c)
        )
    )
)

(area 18 30 24)