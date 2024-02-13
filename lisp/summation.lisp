(defun summation(x)
    (if (> x 0)
        (+ x (summation (- x 1)))
        x
    )
)