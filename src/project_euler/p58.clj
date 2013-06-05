(ns project-euler.p58
   (:require [project-euler.primes  :as primes]))



(println
(loop [init 1 sl 3 pc 0 totc 1 ]
  (let [step (dec sl)
        diagonal [(+ init step) (+ init (* step 2)) (+ init (* step 3)) ]
        pirate (/ pc totc 1.0 )]
    (if (and (> sl 3) (> 0.1 pirate)) (- sl 2)
  (recur
   (+ init (* step 4))
   (+ sl 2)
   (+ pc (->> diagonal
              (filter primes/prime?)
              count))
   (+ totc 4)
   )))))