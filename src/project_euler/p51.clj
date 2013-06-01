(ns project-euler.p51
   (:require [project-euler.primes  :as primes])
     (:require [clojure.math.combinatorics :as combo]))



;Prime digit replacements
;Problem 51
;By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

;By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

;Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.

(time
(println
   (for [a (range 10)
         b (range 10)
         c (range 10)
         ; d (range 10)
         ; d (range 10)
;         :let [p (Integer. (str a b c))
;               p? (primes/prime? p)]
         ;:when (odd? c)
         ;:when (pos? (mod (+ a b c ) 3))
         :let [pgen (Integer. (str a b c ))
               p?gen (primes/prime? pgen)]
         :when p?gen
         :let
           [gens
            (for [t (range 0 10)
                  :let [snum (apply str [ t t a t b c ])]
                  :when (not= (first snum) \0)

                  :let [n (read-string snum)]
                  :when (primes/prime? n)]
              n)
            lgens (count gens)
            mgen (first gens)]
         :when (>= lgens 7)
         ]
      [mgen  lgens pgen p?gen])))



(defn digitscount [n]
  (->> n
       str
       frequencies
       vals
       (apply max)
    ))


(defn analizator [n]
   [n (frequencies (str n))]
       )

(println
 (combo/combinations  [0 1 2 3 4 5] 4))





(defn solver [vd va]
  (->> (primes/primes3 1000000)
       (filter #(= (+ (count vd) (count va)) (count (str %))))
       (filter #(<= (count va) (digitscount %)))
       (group-by
        (fn [n]
          [ (apply =  (map #(nth (str n) %) va ))
           ;(nth (str n) 0)
           ;(nth (str n) 1)
           ;(nth (str n) 2)
            (map #(nth (str n) %) vd)


           ]))
       (filter (fn [[[a & args] coll]] a ))
       (filter (fn [[cod coll]] (>= (count coll) 8)))
       ;(sort-by (fn [[cod coll]] (count coll)))
       ;(map grouper)


       ;(map analizator)
    ))




(time
 (println
  (let [inds [0 1 2 3 4 5]
        diffes  (map set (combo/combinations  inds 3))
        alls  (map
                (fn [df]
                  [df  (clojure.set/difference (set inds) df)]) diffes)]

  (for [[difind samind] alls  ]
    (solver (vec difind) (vec samind))

    ))))
;[[true (2 3 3)] [424343 121313 626363 929393 323333 525353 828383 222323]]