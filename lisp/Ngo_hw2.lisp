(defun square(x)
    (* x x)
)

(defun recfastpow(x n)
    (if (= n 0)
        1
        (if (= (mod n 2) 0)
            (square (recfastpow x (/ n 2)))
            (* x (square (recfastpow x (/ (- n 1) 2))))
        )
    )
)

(defun iterfastpow(x n) (ifp 1 x n 0))
(defun ifp(r b c l)
    (if (= c l)
        r
        (if (= (mod c 2) 0)
            (square (ifp r b (/ c 2) l))
            (* b (square (ifp r b (/ (- c 1) 2) l)))
        )
    )
)

; nth is already defined in lisp
(defun mynth(i x) (nloop x 0 i))
(defun nloop(y c l)
    (if (= c l)
        (first y)
        (nloop (rest y) (+ 1 c) l)
    )
)

(defun flatten(l)
    (if (null l)
        l
        (if (atom (first l))
            (cons (first l) (flatten (rest l))) 
            (append (flatten (first l)) (flatten (rest l)))
        )
    )
)