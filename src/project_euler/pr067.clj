(ns project-euler.pr067)



(def triangle
(->>  "http://projecteuler.net/project/triangle.txt"
      slurp
      (clojure.string/split-lines)
      (map #(clojure.string/split % #"[ ]"))
      (map (fn [coll] (map #(Integer. %) coll)))
      )
  )



(def solve067
(loop [accum-route (first triangle) tmp-route (second triangle) new-routes (drop 2 triangle)]
  (let [new-accum-route
          (->>
               (->>(concat [(first accum-route)] accum-route [(last accum-route)])
                   (partition 2 1 )
                   (map #(apply max %)))
               (map + tmp-route))]
    (if (empty? new-routes)
      (apply max new-accum-route)
      (recur new-accum-route (first new-routes) (rest new-routes)  ))
     )
  ))

(time (println solve067))