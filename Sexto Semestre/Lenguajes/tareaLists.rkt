#|
Functions to solve the List homework
Juan Francisco Gortarez Ricardez
27/03/2020
|#

#lang racket

(define (sum-list list) ;Function to sum all the elements of a list. IN: list. OUT: result (number)
(let loop
    (
     [data list]
     [result 0]
    )
     (if (empty? data)
        result
        (loop (cdr data) 
              (+ (car data) result)
        )
     )

)
)

(define (dot-product list1 list2) ;Calculates dot product of two lists OF EQUAL SIZE. IN: List List. OUT: product (number)
(let loop
    (
     [list1 list1]
     [list2 list2]
     [product 0]
    )

    (if (empty? list1)
        product
        (loop (cdr list1) 
            (cdr list2) 
            (+ (* (car list1) (car list2)) product) ;Sum the product of a pair of numbers in the same position in each list. 
        )
    )

)
)

(define (sizeofList list) ;Helper function to obtain the size of a list. IN: List. OUT: size (number)

(let loop
    (
        [list list]
        [size 0]
    )

    (if (empty? list)
        size
        (loop (cdr list) (+ 1 size) )
    
    )
)
)

(define (mean lst) ;Function to obtain the arithmetic mean of the elements inside a list. IN: List. OUT: mean (number)
(if (empty? lst)
    0 
    (/ (sum-list lst) (sizeofList lst))
)

)

(define (standard-deviation lst) ;Function to obtain the StDev of the elements inside a list. IN: List OUT:Stdev (number)
(let loop
    (
        [list lst]
        [innerSum 0]
        [mean (mean lst)]
        [listSize (sizeofList lst)]
    )
    (if (not (zero? listSize)) ;If list is empty, return 0. Else, continue. 
        (if (empty? list)
            (sqrt (/ innerSum listSize))
            (loop (cdr list)
                  mean
                  (+ (* (- (car list) mean) (- (car list) mean) ) innerSum) ;Represents Σ(x-µ)^2
                  listSize
            )
        )
        0
    )
)
)




