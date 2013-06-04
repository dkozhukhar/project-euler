(ns project-euler.p54
)

(def games
 (map #(clojure.string/split % #"[ ]")
           (clojure.string/split-lines
"8C TS KC 9H 4S 7D 2S 5D 3S AC
5C AD 5D AC 9C 7C 5H 8D TD KS
3H 7H 6S KC JS QH TD JC 2D 8S"
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


(defn pw [n] (reduce * (repeat n 10)))


(defn scores [ranks]
;(scores [8 10 12 9 10 ]) 
(reverse
 (sort
(map 
 (fn [[r n]] (+ r (pw n)))
 (into []
      (frequencies ranks))))))



(let [cards ["8C" "TS" "KC" "9H" "4S"]
      samesuit (apply = (map suit cards))
      allstraight (some identity (map #(= (sort (map rank cards))  %)  (partition 5 1 (range 2 15))))
      ranks (sort (map rank cards))
      groups (frequencies (map rank cards))]
     (cond
      (and samesuit allstraight) ["straight flash" ranks]
      samesuit ["flash" ranks]
      allstraight ["straight" ranks]
      :else ["other" ranks])
)



(defn solve [game]
  (let [player1 (take 5 game)
        player2 (drop 5 game)
        ]
   player2))



(time
 (println
  (map solve games)))
