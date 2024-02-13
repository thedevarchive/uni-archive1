(defun square(x)
    (* x x)
)

(defun factorial(x)
    (if (< x 1) 
        1
        (* x (factorial (- x 1)))
    )
)

(defun pow(x n)
    (if (< n 1)
        1
        (* x (pow x (- n 1)))
    )
)

(defun fastpow(x n)
    (if (= n 0)
        1
        (if (= (mod n 2) 0)
            (square (fastpow x (/ n 2)))
            (* x (square (fastpow x (/ (- n 1) 2))))
        )
    )
)