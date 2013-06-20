(ns project-euler.pr072
    (:require
    [project-euler.primes  :as primes]))



(defn lots-of-primes [n]
  (set
  (take-while (fn [x] (>= n x)) (primes/lazy-primes3) )))

(defn phi [multiples] ; euler's phi function, this is project euler problem btw
  (* (reduce * multiples)
     (reduce *
      (map
      (fn [p]  (- 1 (/ p)))
      (set multiples)
      ))
     ))


(->>
  (for [p (lots-of-primes 1000000)
        ;:when (>= 1000000 p)
        ]
    (phi [p]))
  (reduce +)
  println
  time
 ) ;37550323525N




(->>
  (for [p1 (lots-of-primes 500000)
        p2 (lots-of-primes (min p1 (quot 1000000 p1)))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2]))
  (reduce +)
  println
  time)
;84021128588N



(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3]))

  (reduce +)
  println
  time)
;79098462416N


(->>

;we need more factors!
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4]))

  (reduce +)
  println
  time)
;50131538148N

(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5]))

  (reduce +)
  println
  time)
;26920109272N

(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6]))

  (reduce +)
  println
  time)
;13566689654N


(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7]))

  (reduce +)
  println
  time)
;6635311336N



(->>

;we need even more factors!

  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8]))

  (reduce +)
  println
  time)


;3181488732N
(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9]))

  (reduce +)
  println
  time)
;1520028376N

(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10]))

  (reduce +)
  println
  time)
;715221688N


(->>

; MORE!

  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11]))

  (reduce +)
  println
  time)
;335445836N


(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11))))

        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12]))

  (reduce +)
  println
  time)
;155176920N


(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13]))

  (reduce +)
  println
  time)
;73012012N

(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 2))))
        p14 (lots-of-primes (min p13 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14]))

  (reduce +)
  println
  time)
;32888336N

(->>

;MOAR!!!

  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2 2 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 2 2))))
        p14 (lots-of-primes (min p13 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 2))))
        p15 (lots-of-primes (min p14 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15]))

  (reduce +)
  println
  time)
;14991488N

(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2 2 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2 2 2 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 2 2 2))))
        p14 (lots-of-primes (min p13 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 2 2))))
        p15 (lots-of-primes (min p14 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 2))))
        p16 (lots-of-primes (min p15 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16]))

  (reduce +)
  println
  time)
;6710272N

(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2 2 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2 2 2 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2 2 2 2 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 2 2 2 2))))
        p14 (lots-of-primes (min p13 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 2 2 2))))
        p15 (lots-of-primes (min p14 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 2 2))))
        p16 (lots-of-primes (min p15 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 2))))
        p17 (lots-of-primes (min p16 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17]))

  (reduce +)
  println
  time)
;2830336N

(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2 2 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2 2 2 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2 2 2 2 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2 2 2 2 2 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 2 2 2 2 2))))
        p14 (lots-of-primes (min p13 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 2 2 2 2))))
        p15 (lots-of-primes (min p14 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 2 2 2))))
        p16 (lots-of-primes (min p15 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 2 2))))
        p17 (lots-of-primes (min p16 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 2))))
        p18 (lots-of-primes (min p17 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 p18]))

  (reduce +)
  println
  time)
;1671168N


(->>

 ;MOAR!!!
 ;MOAR!!!
 ;MOAR!!!

  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2 2 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2 2 2 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2 2 2 2 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2 2 2 2 2 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2 2 2 2 2 2 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 2 2 2 2 2 2))))
        p14 (lots-of-primes (min p13 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 2 2 2 2 2))))
        p15 (lots-of-primes (min p14 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 2 2 2 2))))
        p16 (lots-of-primes (min p15 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 2 2 2))))
        p17 (lots-of-primes (min p16 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 2 2))))
        p18 (lots-of-primes (min p17 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 2))))
        p19 (lots-of-primes (min p18 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 p18))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 p18 p19]))

  (reduce +)
  println
  time)
;524288N


(->>
  (for [p1 (lots-of-primes 1000000)
        p2 (lots-of-primes (min p1 (quot 1000000 (* p1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p3 (lots-of-primes (min p2 (quot 1000000 (* p1 p2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p4 (lots-of-primes (min p3 (quot 1000000 (* p1 p2 p3 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p5 (lots-of-primes (min p4 (quot 1000000 (* p1 p2 p3 p4 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p6 (lots-of-primes (min p5 (quot 1000000 (* p1 p2 p3 p4 p5 2 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p7 (lots-of-primes (min p6 (quot 1000000 (* p1 p2 p3 p4 p5 p6 2 2 2 2 2 2 2 2 2 2 2 2 2))))
        p8 (lots-of-primes (min p7 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 2 2 2 2 2 2 2 2 2 2 2 2))))
        p9 (lots-of-primes (min p8 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 2 2 2 2 2 2 2 2 2 2 2))))
        p10 (lots-of-primes (min p9 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 2 2 2 2 2 2 2 2 2 2))))
        p11 (lots-of-primes (min p10 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 2 2 2 2 2 2 2 2 2))))
        p12 (lots-of-primes (min p11 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 2 2 2 2 2 2 2 2))))
        p13 (lots-of-primes (min p12 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 2 2 2 2 2 2 2))))
        p14 (lots-of-primes (min p13 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 2 2 2 2 2 2))))
        p15 (lots-of-primes (min p14 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 2 2 2 2 2))))
        p16 (lots-of-primes (min p15 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 2 2 2 2))))
        p17 (lots-of-primes (min p16 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 2 2 2))))
        p18 (lots-of-primes (min p17 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 2 2))))
        p19 (lots-of-primes (min p18 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 p18 2))))
        p20 (lots-of-primes (min p19 (quot 1000000 (* p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 p18 p19))))
        ;:when (>= 8 (* p1 p2))
        ]
    (phi [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 p11 p12 p13 p14 p15 p16 p17 p18 p19 p20]))

  (reduce +)
  println
  time)
;0

; ok then!


(->>
(+
37550323525N
84021128588N
79098462416N
50131538148N
26920109272N
13566689654N
6635311336N
3181488732N
1520028376N
715221688N
335445836N
155176920N
73012012N
32888336N
14991488N
6710272N
2830336N
1671168N
524288N)
println)
;303963552391N




