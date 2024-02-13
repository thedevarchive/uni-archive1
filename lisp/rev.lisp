(defun rev(x)
    (if (null x)
        x
        (append
            (rev (rest x)
            (list (first x)))
        )
    )
)