#lang racket

(define (print-out lines)
    (let loop 
        ([n 1])
        (if (> n 10)
        (displayln "Finished")
        (begin 
            (displayln n out)
            (loop (add1 n))
        )
        
        )
    )

)

(define (read-lines in)
   (define line (read-line in))
   (if (eof-object? line)
        (displayln "Finished reading")
        (begin
            (displayln line)
            (read-lines in)
        )
   
   )

)

(define out (open-output-file "test.txt" #:exists 'truncate))
(displayln "text that goes in the file" out)
(print-out out)
(close-output-port out)

(define in (open-input-file "test.txt"))
(read-lines in)
(close-input-port in)

(call-with-output-file "test.txt" #exists 'truncate print-out)

