(ns project-euler.p65)


(defn converg [coll]
  (+ (first coll) (if (empty? (rest coll)) 0 (/ (converg (rest coll))))))


(->> (range 1 35)
     (map (fn [n] [1 (* n 2) 1]))
     (apply concat)
     (cons 2)
     (take 100)
     converg
     numerator
     str
     (map int)
     (map #(- % 48))
     (reduce +)
     )
