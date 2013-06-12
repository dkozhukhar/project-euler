(ns project-euler.p63)

(defn pow [a n] (reduce * (repeat n a)))

(let [sol
      (for [b (range 1N 10N)
            m (range 1 50)
            :let [pint (pow b m)
                  np (->> (pow b m) str count)]
            :when (= np m)]
           [b, m, pint])]
     (do 
      (println sol)
      (println (count sol))))
