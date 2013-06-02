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



(for [s (group-by suit ["8C" "TS" "KC" "9H" "4S"])]
  (map rank (second s)))




(defn solve [game]
  (let [player1 (take 5 game)
        player2 (drop 5 game)
        ]
   player2))



(time
 (println
  (map solve games)))