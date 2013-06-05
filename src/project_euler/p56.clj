(ns project-euler.p56
     (:require    [project-euler.utils  :as utils])
  )

(defn digitsum [nu]
  (apply + (map utils/char-to-int (str nu))))

(apply max
(for [a (range 1N 100)]
     (apply max (map digitsum (reductions * (replicate 99 a))))))
