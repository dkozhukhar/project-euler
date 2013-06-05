(ns project-euler.p57
)

(->> (take 1000 (map #(inc (/ %))  (iterate #(+ 2 (/ %)) 2)))
     (filter 
      (fn [r] (> (->> r numerator str count) (->> r denominator str count))))
     count
     println)
