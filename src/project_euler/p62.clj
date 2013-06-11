(ns project-euler.p62)

(defn tri [n] (* n n n))

(->>
 (->> (range 1 10000)
      (group-by #(sort(str(tri %))))
      (filter #(= (count(val %)) 5))
      (apply min-key #(apply min (val %)))
      second
      (apply min)
      tri
      )
 println
 time)
