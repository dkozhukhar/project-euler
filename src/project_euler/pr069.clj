(ns project-euler.pr069
    (:require              
    [project-euler.primes  :as primes]))

(def sol069
(->> (primes/lazy-primes3)
     (reductions *)
     (take-while #(>= 1000000 %))
     last
     ))

(->> sol069
     println
     time)
