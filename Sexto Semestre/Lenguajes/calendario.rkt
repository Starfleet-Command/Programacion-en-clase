#|
    Program to output the next day of a given date
    Juan Francisco Gortarez Ricardez
    07/03/2020
|#


#lang racket

(define (leap? year) ;Helper function to check if a given year is a leap year
    (if (zero? (modulo year 4))
        (if (zero? (modulo year 100))
            (if (zero? (modulo year 400))
                #t  ; Divisible by 400
                #f) ; Divisible by 100
            #t) ; Divisible by 4
        #f))    ; Not divisible by 4


(define (daysInMonth month year) ;List definition of the number of days in a month, accounting for leap years
(case month
[(1 3 5 7 8 10 12) 31]
[(4 6 9 11) 30]
[(4 6 9 11) 30]
[(2) (if (leap? year) 29 28 ) ]

)
)


(define (isLastDay? day month year) ;Check to see if day is the last day in month
    (if (<= (daysInMonth month year)  day) #t #f )
)

(define (isLastMonth? month) ;Check to see if month is the last month (simplifies code readability)
(if (equal? month 12) #t #f)
)

(define (Calendar day month year)
(cond
[(and (isLastDay? day month year) (not (isLastMonth? month)) ) (list 1 (+ 1 month) year)]
[(and (isLastDay? day month year)  (isLastMonth? month)) (list 1 1 (+ 1 year))]
[else (list (+ 1 day) month year)]
)
)

(Calendar 28 2 2020) ;Leap year test
(Calendar 28 2 2021) ;Non-leap year month change test
(Calendar 29 2 2020) ;Leap year & month change test
(Calendar 31 12 2020) ;Year Change Test
(Calendar 19 12 2020) ;Normal change test (& my birthday)
(Calendar 19 13 2020) ;Invalid date test