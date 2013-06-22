(ns project-euler.pr074)

(defn new-n [n]
(->>
 n
 str
 (map (fn [d]
        (case d
          \0 1
          \1 1
          \2 2
          \3 6
          \4 24
          \5 120
          \6 720
          \7 5040
          \8 40320
          \9 362880)))
 (reduce +)
  ))


(defn non-repeat-count [x]
(->>
 (take 60 (iterate new-n x))
 distinct
 count
 (= 60)
 ))


(->> 1000000
     (range 1)
     (filter non-repeat-count)
     count
     println
     time
     )