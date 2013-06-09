(ns project-euler.p60
   (:require [project-euler.primes  :as primes]))

(def p10000 (vec (take-while #(> 10000 %) (primes/lazy-primes3))))

(defn tp [n]
  "tests n for being a prime by trial division using some prime sieve p10000"
  (->> (take-while #(< % (->> n
                              Math/sqrt
                              Math/floor
                              inc)) p10000)
       (map #(mod n %))
       (every? pos?)
       ))


(defn dual [a b]
  (and (tp (read-string (str a b))) (tp (read-string (str b a)))))


(println (->> p10000 (drop-while #(<= % 10000))))


(->>
       (for [x (take 20 p10000)
             :let [xsieve p10000]

             :let [ysieve (->> xsieve (drop-while #(<= % x)) (filter #(dual x %)))]
             y ysieve
             :let [zsieve (->> ysieve (drop-while #(<= % y)) (filter #(dual y %)))]
             z zsieve
             :let [wsieve (->> zsieve (drop-while #(<= % z)) (filter #(dual z %)))]
             w  wsieve
             :let [vsieve (->> wsieve (drop-while #(<= % w)) (filter #(dual w %)))]
             v vsieve
             ]
         [x y z w v]
         )

     ;(map #(reduce + %))
     ;(apply min)
     println
     time)



