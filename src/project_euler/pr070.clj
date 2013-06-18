(ns project-euler.pr070
    (:require
    [project-euler.primes  :as primes]))


(def pt (take 600 (primes/lazy-primes3)))

(last pt)

(defn perm? [a b] (= (sort (str a)) (sort (str b)) ) )

(defn phi [m1 m2]
  (if (not= m1 m2)
    (- (dec (* m1 m2))
       (dec m2)
       (dec m1))
    (- (dec (* m1 m2))
       (dec m1))))


(->>
  (for [t1 pt
        t2 pt
        :let [n (* t1 t2)
              ph (phi t1 t2)
              ra (/ n ph)]
        :when (> 10000000 n)
        :when (perm? n ph  )
        ]
    [t1 t2 n ph ra])
 (sort-by (fn [[x y a b c]] c))
 first
 println
 time)
