(ns project-euler.p54
)

(def games
 (map #(clojure.string/split % #"[ ]")
           (clojure.string/split-lines
(slurp "http://projecteuler.net/project/poker.txt")
 )))



(defn suit [card]   (subs card 1 2))


(defn rank [card]
  (case (subs card 0 1)
    "A" 14
    "K" 13
    "Q" 12
    "J" 11
    "T" 10
    (read-string (subs card 0 1))))


(defn srt-ranks [ranks]
 (let [my-map (frequencies ranks )]
  (into (sorted-map-by (fn [key1 key2] ;sorts a map by value
                         (compare [(get my-map key2) key2]
                                  [(get my-map key1) key1])))
        my-map)))

(defn scores [ranks]
  (let [scr
         (frequencies ranks)
      scrv (sort (vals scr))
      scrvec (into [] scr)
      sr (into [] (srt-ranks ranks))
      ]
  (cond
   (= scrv '(2 3)) [7 sr]
   (= scrv '(1 1 3)) [4 sr]
   (= scrv '(1 4)) [8 sr]
   (= scrv '(1 2 2)) [3 sr]
   (= scrv '(1 1 1 2)) [2 sr]
   (= scrv '(1 1 1 1 1)) [1 sr]
   )))




(defn combs [cards]
  (let
      [samesuit (apply = (map suit cards))
      allstraight
        (some identity
              (map #(= (sort (map rank cards))  %)  (partition 5 1 (range 2 15))))
      ranks (sort (map rank cards))
      groups (frequencies (map rank cards))
      sr (into [] (srt-ranks ranks))
       ]
     (cond
      (and samesuit allstraight) [9 sr]
      samesuit [6 sr]
      allstraight [5 sr]
      :else (scores ranks)
      )
))




(println
 (count
 (filter #(= 1 %)
  (map (fn [game]
          (let [player1 (take 5 game)
                player2 (drop 5 game)
                ]
         (compare
            (combs player1)
            (combs player2)) )
               )
   games))))



