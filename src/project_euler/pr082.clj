(ns project-euler.pr082)

(def matrix
(->>  "http://projecteuler.net/project/matrix.txt"
      slurp
      (clojure.string/split-lines)
      (map #(clojure.string/split % #"[,]"))
      (map (fn [coll] (map #(Integer. %) coll)))
      (map vec)
      vec
      ))

(def lmatrix
[     
[131  673  234	103	18]
[201	96	342	965	150]
[630	803	746	422	111]
[537	699	497	121	956]
[805	732	524	37	331]
])


(def msize 80)

(def tmatrix
(vec     
(for [x (range msize)]
     (vec
     (for [y (range msize)]
          ((matrix y) x)        
          )))))




(defn solver [accum v2]
(vec
(for [fi (range 0 msize)]  
    (apply min
      (for [st (range 0 msize)
           :let [a (min st fi)
                 b (max st fi)]]
           (reduce + (accum st)
                  (for [s (range a (inc b))]
                       (v2 s))))))))

(time (println (apply min (reduce solver  tmatrix))))


