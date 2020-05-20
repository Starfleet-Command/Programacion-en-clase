#|
Read a file, process data and write new file with processed data. 
|#

#lang racket

(define (lines->list in)
(let loop
    ([result empty])
    (define line (read-line in))
    (if (eof-object? line)
            result
            (loop (append result (list (string->number line))))
    
    )
)
)

(define (write-powers n out)
(display n out)
(display " " out)
(display (* n n) out)
(display " " out)
(displayln (* n n n) out)
)

(define (make-powers in-file out-file)
(define data (call-with-input-file in-file lines->list))
(display data)
(call-with-output-file out-file #:exists 'truncate 
(lambda (out)
    (let loop
    ([data data])
    (if (empty? data)
        (displayln "Finished")
        (begin
            (write-powers (car data) out)
            (loop (cdr data))
        )
    )
    )
    )

)
)

(make-powers "test.txt" "testPowers.txt")